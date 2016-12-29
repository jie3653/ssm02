package com.sm1.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//此类为切面类
@Aspect
@Component
public class UserServiceAspect {
	//定义切入点的模式
		/** 
		 * //com.service.包下的所有类的方法在调用时增加日志
		 * execution 中的第一个*号代表切入点拦截到的方法的返回类型，*代表任意
		 * com.service2..* 代表com.service2包及其子包下的所有类
		 * .包的分隔符
		 * .*代表类中的所有方法
		 * (..)方法参数有0个或多的的方法
		 */
		@Pointcut("execution(* com.sm1.service..*.*(..))")
		public void myPoint(){}
		
		/*环绕通知*/
		@Around(value="myPoint()")//环绕通知（使用环绕通知的话，可以不用上面的前置，后置等通知）
		public Object around(ProceedingJoinPoint pjp){
//			String className = pjp.getTarget().getClass().getName();//获得被代理类
//			System.out.println(className);
//			String mName = pjp.getSignature().getName();//method name
//			System.out.println(mName);
//			Object[] o = pjp.getArgs();//获得方法的参数
//			for(Object ma:o){//打印出方法参数
//				if(ma != null && ma.getClass().isArray()){
//					System.out.println(Arrays.toString((Object[])ma));
//				}else{
//					System.out.println(ma);
//				}
//			}
			long between = 0;
			try {
				Date start1 = new Date();
				long start = start1.getTime();
				System.out.println("前置通知");
				Object value = pjp.proceed();//调用被代理对象的方法（控制方法的使用） 返回方法的返回值
				Date end1 = new Date();
				long end = end1.getTime();
				between = end-start;
				System.out.println("时间差："+between);
				//System.out.println(value);
				System.out.println("添加成功");
				return value;//返回方法的返回值
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("异常通知");
			}finally{
				System.out.println("最终通知");//可做资源的关闭等
			}
			
			return null;
		}
		
			
}
