package com.in28minutes.springboot.web.service;

import org.springframework.stereotype.Component;

// Spring Bean

// Component. Spring will manage this
@Component
public class LoginService {
	
	public boolean validateUser(String userid, String password) {
		// in 28minutes, dummy
		
		return userid.equalsIgnoreCase("in28minutes") 
		&& password.equalsIgnoreCase("dummy");
		
	}

}
