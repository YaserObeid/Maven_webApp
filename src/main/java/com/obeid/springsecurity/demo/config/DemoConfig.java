package com.obeid.springsecurity.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.obeid.springsecurity.demo")
@PropertySource("classpath:db.properties")
public class DemoConfig implements WebMvcConfigurer{
	
	// inject the db.properties
	@Autowired
	private Environment env;
	
	// define Internal Resource ViewResolver
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = 
				new InternalResourceViewResolver();
		
		// set per-suffix -> /WEB-INF/view/home.jsp
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		// This allows you serving up content 
		// from the "/asset" directory
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		registry.addResourceHandler("/asset/**").addResourceLocations("/asset/");
	}
	
	
	
	
	

}
