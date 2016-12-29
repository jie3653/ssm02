package com.sm1.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sm1.pojo.User;
import com.sm1.pojo.UserExample;
import com.sm1.service.UserService;

public class AopTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx 
		= new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		//继承了接口用接口接收
		UserService userService = (UserService) ctx.getBean("userServiceImpl");
		
		UserExample ue = new UserExample();
		//2criteria来构造查询条件
		UserExample.Criteria criteria = ue.createCriteria();
		//查名字like2
		criteria.andUsernameLike("%2%");
		List<User> users = userService.selectByExample(ue);
		
		System.out.println(users.size());
	}
}
