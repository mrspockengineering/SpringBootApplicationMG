package com.in28minutes;

import org.springframework.stereotype.Component;

@Component
public class DummyService {
	
	public boolean validateUser(String name, String password) {
		return name.equalsIgnoreCase("dummy") ||
				name.equalsIgnoreCase("dummy1")
				&& password.equalsIgnoreCase("dummy");
	}

}
