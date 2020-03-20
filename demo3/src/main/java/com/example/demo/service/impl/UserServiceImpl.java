package com.example.demo.service.impl;

import java.util.Date;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

	 @Autowired
	 private UserMapper userMapper;
	 
	@Override
	public int add(User user) {
		userMapper.insert(user);
		int id = user.getId();
		return id;
	}
	
	
	

	
	
}
