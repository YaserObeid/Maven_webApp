package com.obeid.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AnnotationDispatcherServletInitializer 
	extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// don't need (have one configClass)
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// have only one configClass
		return new Class[] {DemoConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// set only the root path
		return new String[] {"/"};
	}

}
