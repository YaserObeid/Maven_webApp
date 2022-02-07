package com.obeid.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

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

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.obeid.springsecurity.demo")
@PropertySource("classpath:db.properties")
public class DemoConfig implements WebMvcConfigurer{
	
	// inject the db.properties
	@Autowired
	private Environment env;
	
	// define a logger for diagnose
	private Logger logger = Logger.getLogger(getClass().getName());
	
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
	
	// define a bean of dataSource
	
		@Bean
		public DataSource dataSource() {
			
			// create connectio pool
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			
			// set driver for dataSource
			try {
				dataSource.setDriverClass(env.getProperty("jdbc.driver"));
			} catch (PropertyVetoException exc) {
				throw new RuntimeException(exc);
				
			}
			
			// log some connection props (just for monitoring)
			logger.info(">>>>>>> jdbc.url: " + env.getProperty("jdbc.url"));
			logger.info(">>>>>>> jdbc.user: " + env.getProperty("jdbc.user"));
			
			// set database connection props (how to connect db)
			dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			dataSource.setUser(env.getProperty("jdbc.user"));
			dataSource.setPassword(env.getProperty("jdbc.password"));
			
			// set the connection pool props
			dataSource.setInitialPoolSize(getIntProperty(
					"connection.pool.initialPoolSize"));
			dataSource.setMinPoolSize(getIntProperty(
					"connection.pool.minPoolSize"));
			dataSource.setMaxPoolSize(getIntProperty(
					"connection.pool.maxPoolSize"));
			dataSource.setMaxIdleTime(getIntProperty(
					"connection.pool.maxIdleTime"));
			
			return dataSource;
			
		}
		
		// helper to convert props string_val -> int
		private int getIntProperty(String propName) {
			
			return Integer.parseInt(env.getProperty(propName));
		}
		
	
	
	

}
