package com.hyh.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hyh.entity.User;

@Mapper
public interface UserMapper {

	public User login(User user);
}
