package com.in28minutes.springboot.web.controller;

import org.springframework.stereotype.Component;

@Component
public class DummyService {
	public boolean isValidate(String name, String password) {
		return name.equalsIgnoreCase("dummy") &&
				password.equalsIgnoreCase("dummy");
	}
}
