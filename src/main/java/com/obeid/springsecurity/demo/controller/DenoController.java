package com.obeid.springsecurity.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class DenoController {
	
	// inject property holder
	@Autowired
	private Environment env;
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	@GetMapping("/test")
	public String testEnvirument(Model model) {
		String test = env.getProperty("foo.test");
		model.addAttribute("test", test);
		return "test";
	}
	
	

}
