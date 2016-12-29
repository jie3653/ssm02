package com.sm1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm1.mapper.UserMapper;
import com.sm1.pojo.User;
import com.sm1.pojo.UserExample;
import com.sm1.service.UserService;
//注解开发service，getBean("userServiceImpl");
//开启事务
//@Transactional
@Service
public class UserServiceImpl implements UserService{
	//注入mapper
	@Autowired
	private UserMapper userMapper;
	

	@Override
	public List<User> selectByExample(UserExample example) {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(example);
	}
	

	@Override
	public int deleteByExample(UserExample example) {
		// TODO Auto-generated method stub
		return userMapper.deleteByExample(example);
	}

	//事务测试删除user及user的后一位
	//@Transactional
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		
		int num1 =  userMapper.deleteByPrimaryKey(id);
		if(num1 > 0){
			System.out.println("删除成功");
		}
		int num2 = userMapper.deleteByPrimaryKey(id+1);
		
		return num1+num2;
	}


	@Override
	public int insertUsersByList(List<User> users) {
		// TODO Auto-generated method stub
		return userMapper.insertUsersByList(users);
	}

}
