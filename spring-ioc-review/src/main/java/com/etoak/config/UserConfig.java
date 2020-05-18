package com.etoak.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etoak.action.UserAction;
import com.etoak.service.UserService;

@Configuration // 相当于xml的根元素<beans>标签，表示这是一个spring ioc容器
public class UserConfig {
	
	/**
	 *   使用@Bean注册spring Bean
	 *   返回类型相当于<bean>标签的class属性   可以不写
	 *   方法名可以认为是<bean>标签的id属性
	 *   
	 * */
	
	@Bean("userService")
	public UserService userService(){
		return new UserService();
	}
	
	@Bean						//@Qualifier相当于<property>里的ref属性	将service注入到Action
	public UserAction userAction(@Qualifier("userService")
	UserService userService){
		
		UserAction userAction = new UserAction();
		//userAction.setUserService(this.userService());
		
		
		// 配合@Qualifier使用
		userAction.setUserService(userService);
		return userAction;
	}
	
}












