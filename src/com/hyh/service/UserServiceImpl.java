package com.hyh.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hyh.entity.User;
import com.hyh.mapper.UserMapper;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapepr;
	
	public User login(User user) {
		return userMapepr.login(user);       
	}

}
