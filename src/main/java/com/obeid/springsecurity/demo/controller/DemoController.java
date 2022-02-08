package com.obeid.springsecurity.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController {
	
	// inject property holder
	@Autowired
	private Environment env;
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	@GetMapping("/test")
	public String showTest(Model model) {
		
		model.addAttribute("User",env.getProperty("jdbc.user"));
		model.addAttribute("Pass",env.getProperty("jdbc.password"));
		model.addAttribute("Url",env.getProperty("jdbc.url"));
		
		return "test";
	}
	
	
	

}
