package com.sm1.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sm1.pojo.User;
import com.sm1.pojo.UserExample;
import com.sm1.service.UserService;

public class TestInsert {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx 
		= new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		UserService userService = (UserService) ctx.getBean("userServiceImpl");
		//测试批量插入
		User u1 = new User();
//		u1.setId(31);
		u1.setUsername("r31");
		u1.setPassword("123456");
		User u2 = new User();
//		u1.setId(32);
		u2.setUsername("r32");
		u2.setPassword("123456");
		User u3 = new User();
//		u1.setId(33);
		u3.setUsername("r33");
		u3.setPassword("123456");
		
		List<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		//批量操作
		int i = userService.insertUsersByList(users);
		if(i > 0){
			System.out.println("插入成功！");
			for(User u:users){
				System.out.println(u.getId()+u.getUsername()+u.getPassword());
			}
			
		}
		
		
	}
	
	


}
