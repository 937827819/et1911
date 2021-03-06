package com.etoak.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;

@Controller
public class IndexController {
	
	@RequestMapping("/add")
	public String add(String name){
		
		System.out.println(name);
		
		return "forward:/index";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public String json(@RequestBody Map<String, Object> map){
		
		System.out.println(map);
		return "SUCCESS";
	}
	
	
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		
		// 向request域传值
		request.setAttribute("user",
			new User(1,"requestUser","",20));
		
		// 向session中传值
		request.getSession().setAttribute("sessionUser", 
			new User(2, "sessionUser","",21));
		
		// 用于测试thymeleaf便利List
		List<User> userList = new ArrayList<>();
		request.setAttribute("userList", userList);
		userList.add(new User(3,"张三","",28));
		userList.add(new User(4,"李四","",22));
		
		// webapp/templates/index.html
		return "index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
