package com.sm1.controller;

/**
 * 
 * @author 周洁
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm1.pojo.User;
import com.sm1.pojo.UserExample;
import com.sm1.service.UserService;

@Controller
public class UserController {
	//注入userService
	@Autowired
	private UserService userService;
		
		//对方法映射url:/queryUser (url一般和方法名一样)
			//访问的a标签写法：<a href="queryUser.action">通过注解访问user</a><br/>
			//一个方法对应一个url
			//.action可以不加
		//查询用户
		@RequestMapping("/queryUser")
		public ModelAndView queryUser(){
			 System.out.println("被访问了");
			//获得分页对象(设置当前页，和页码大小)
			PageHelper.startPage(2,2);
			
			UserExample userExample = new UserExample();
			UserExample.Criteria criteria = userExample.createCriteria();
			criteria.andUsernameLike("%2%");
			List<User> users = userService.selectByExample(userExample);
			PageInfo<User> info = new PageInfo<>(users);
			//返回modelandview
			ModelAndView modelandview = new ModelAndView();
				//1填充数据到页面，相当于request的setAtrribute 在jsp中直接访问users拿到数据
			modelandview.addObject("users",users);
			modelandview.addObject("info",info);
				//2指定视图(指定传入的jsp 路径：/WEB-INF/jsp/user2.jsp)
			modelandview.setViewName("/WEB-INF/jsp/user2.jsp");
				//返回modelandview
			return modelandview;			
		}
		
}
