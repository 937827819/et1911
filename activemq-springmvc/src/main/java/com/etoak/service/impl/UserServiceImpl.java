package com.etoak.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.bean.User;
import com.etoak.mapper.UserMapper;
import com.etoak.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	
	@Override
	public int addUser(User user) {
		
		String userId = UUID.randomUUID().toString().replace("-", ""); 
		user.setUserId(userId);
		user.setStatus(0);
		return userMapper.addUser(user);

	}

}
