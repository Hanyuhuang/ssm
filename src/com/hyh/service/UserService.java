package com.hyh.service;

import org.springframework.stereotype.Service;

import com.hyh.entity.User;

@Service
public interface UserService {

	public User login(User user);
}
