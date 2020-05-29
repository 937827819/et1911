package com.etoak.service.impl;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.etoak.bean.Email;
import com.etoak.bean.User;
import com.etoak.mapper.UserMapper;
import com.etoak.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	JmsTemplate jsmtemplate;
	
	@Override
	public int addUser(User user) {
		
		String userId = UUID.randomUUID().toString().replace("-", ""); 
		user.setUserId(userId);
		user.setStatus(0);
		int result = userMapper.addUser(user);
		
		// 使用JmsTemplate向消息队列发送消息
		jsmtemplate.send("email",new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				
				Email email = new Email(
					user.getEmail(),
					"注册激活邮件",
					"请点击右侧链接: "
					+ "http://localhost:8080/activemq-springmvc/user/active"
					+ userId
				);
				
				
				return session.createTextMessage(JSONObject.toJSONString(email));
			}
		});
		
		return result;

	}

}
