package com.etoak.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常处理器
 * 注解@ComtrollerAdvice会在所有被@Controller注解的方法上海加一个拦截，
 * 当控制器的方法有异常
 * 
 * */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	/**
	 * 表示这个方法只拦截ParamException异常
	 * */
	@ExceptionHandler(ParamException.class)
	public ModelAndView handleParamException(ParamException e){
	
		String message = e.getMessage();
		
		log.error(message,e);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("paramError", message);
		
		// 页面: /templates/car/add.html
		mv.setViewName("car/add");
		return mv;
	}
}
