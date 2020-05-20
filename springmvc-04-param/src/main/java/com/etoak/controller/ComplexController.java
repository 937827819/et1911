package com.etoak.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.Student;


/**
 * 测试java bean接收参数
 * 测试数组接收参数
 * 测试List接收参数
 * 测试Map接收参数
 * 
 * */
@Controller
@RequestMapping("/complex")
public class ComplexController {
	
	// Git请求：@RequestMapping的method属性指定
	// Git请求：@GetMapping
	@GetMapping("/bean")
	public String bean(Student student,Model model){
		System.out.println(student);
		model.addAttribute("result2","使用Model传值");
		
		// 请求转发到/simple/simple(这个请求在SimpleController中)
		return "forward:/simple/simple?id=321";
		
	}
	
	/**
	 * 
	 * 
	 * */
	@PostMapping("/array")			   // ModelMap: 向前端传值
	public String array(String[] hobby,ModelMap modelMap){                                
		for(String hobbyStr : hobby){
			System.out.println("hobby - " + hobbyStr);
		}
		
		modelMap.addAttribute("result - ", "使用ModelMap传参");
		return "param";
		
	}
	
	@PostMapping("/list")			   // ModelMap: 向前端传值
	public String list(Student student,
			Map<String, Object> map){                                
		List<String> hobbyList = student.getHobbyList();
		if(!CollectionUtils.isEmpty(hobbyList)){
			hobbyList.forEach(x -> System.out.println(x));
		}
		
		map.put("result - ", "使用List传参");
		return "param";
	
	}
	
	/**
	 *  使用map
	 * 
	 * */
	@RequestMapping(value="/map",produces= {"text/plain"})
	@ResponseBody // 可以返回json,xml,纯文本
	public String map(Student student){
		System.out.println(student.getStuMap());
		
		return "success";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
