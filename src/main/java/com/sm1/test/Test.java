package com.sm1.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.sm1.pojo.User;
import com.sm1.pojo.UserExample;
import com.sm1.service.UserService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx 
		= new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		UserService userService = (UserService) ctx.getBean("userServiceImpl");
		//测试添加方法
		/*User u1 = new User();
		u1.setId(5);
		u1.setUsername("r5");
		u1.setPassword("123456");
		int id = um.insertSelective(u1);*/
		
		//测试查询方法
		/*User u = um.selectByPrimaryKey(2);
		System.out.println(u.getId()+u.getUsername()+u.getPassword());*/
		
		//测试自定义查询
		//1创建一个UserExample对象
		UserExample ue = new UserExample();
		//2criteria来构造查询条件
		UserExample.Criteria criteria = ue.createCriteria();
		//查名字like2
		criteria.andUsernameLike("%2%");
		List<User> users = userService.selectByExample(ue);
		System.out.println(users.size());
		//批量操作
//		um.updateByPrimaryKeySelective(record)
//		um.insertSelective(record)
		
////		批量添加，开启事务
//		insertUserList(um);
		
		//sqlSession session  = SqlSessionTemplate.
	}

//	private static void insertUserList(UserMapper um) {
//		// TODO Auto-generated method stub
//		
//	}

	

}
