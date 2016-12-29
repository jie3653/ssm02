package com.sm1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sm1.service.UserService;

public class TransactionTest {
	public static void main(String[] args) {
		ApplicationContext ctx 
		= new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		UserService userService = (UserService) ctx.getBean("userServiceImpl");
		
		//测试删除方法，执行删除看会不会回滚
//		UserExample ue = new UserExample();
//		//2criteria来构造查询条件
//		UserExample.Criteria criteria = ue.createCriteria();
//		
//		criteria.andUsernameLike("%1");
//		int i = userService.deleteByExample(ue);
		
		int i = userService.deleteByPrimaryKey(3);
		System.out.println("删除的行"+i);
	}
}
