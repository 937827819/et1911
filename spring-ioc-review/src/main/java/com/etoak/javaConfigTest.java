package com.etoak;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etoak.action.UserAction;
import com.etoak.bean.User;
import com.etoak.config.UserConfig;
import com.etoak.service.UserService;

public class javaConfigTest {

	public static void main(String[] args) {
	
		ApplicationContext ac = new AnnotationConfigApplicationContext(UserConfig.class);
		
		UserAction userAction = ac.getBean(UserAction.class);
		User user = userAction.getById(200);
		
		System.out.println(user.getId() + ":" + user.getName());
		
	}

}
