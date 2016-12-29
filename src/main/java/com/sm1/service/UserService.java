package com.sm1.service;

import java.util.List;

import com.sm1.pojo.User;
import com.sm1.pojo.UserExample;

public interface UserService {
	List<User> selectByExample(UserExample example);
	
	int deleteByExample(UserExample example);
	
	int deleteByPrimaryKey(Integer id);
	
	int insertUsersByList(List<User> users);
}
