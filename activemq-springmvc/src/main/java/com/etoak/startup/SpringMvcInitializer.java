package com.etoak.startup;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.etoak.config.RootConfig;
import com.etoak.config.SpringMvcConfig;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	// spring root容器
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { RootConfig.class};
	}
	
	
	// spring mvc容器
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { SpringMvcConfig.class};
	}
	
	
	// DispatcherServlet拦截地址
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
