package com.sm1.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm1.pojo.User;
import com.sm1.pojo.UserExample;
import com.sm1.service.UserService;

public class TestPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx 
		= new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		UserService userService = (UserService) ctx.getBean("userServiceImpl");
//		System.out.println("请输入你想到第几页");
//		int page = input.nextInt();
//		System.out.println("请输入每页的页数");
//		int pageCount = input.nextInt();
//		PageHelper.startPage(page, pageCount);
		
		PageHelper.startPage(1, 4);
		//测试自定义查询
		//1创建一个UserExample对象
		UserExample ue = new UserExample();
		//2criteria来构造查询条件
//		UserExample.Criteria criteria = ue.createCriteria();
		//查名字like2
//		criteria.andUsernameLike("%2%");
		
		List<User> users = userService.selectByExample(ue);
		
		PageInfo<User> info = new PageInfo<>(users);
		
		System.out.println("该数据共有"+info.getTotal()+"条");
		System.out.println("第几页：");
		System.out.println("当前页数目："+info.getPageSize());
		//System.out.println("userList" + userList.size());
		for (User user : users) {
			System.out.println(user.getId() + "	" + user.getUsername() + "	"+user.getPassword());
		}
	}

}
