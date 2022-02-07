package com.obeid.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DenoController {
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}

}
