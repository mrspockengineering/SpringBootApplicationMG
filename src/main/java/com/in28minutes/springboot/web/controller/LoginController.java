package com.in28minutes.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// login => "Hello World"
@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String loginMessage() {
		return "Hello World";
	}

}