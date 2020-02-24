package com.in28minutes.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in28minutes.springboot.web.service.LoginService;

// login => "Hello World"
@Controller
public class LoginController {
	
	// Model
	/* View: renders Data */
	
	/* bisher:
	LoginService service = new LoginService();
	*/
	
	// DependencyInjection; Advantage: works like Interface
	//		service can be replaced (like Database and LDAP)
	@Autowired
	LoginService service;
	
	@Autowired
	DummyService dummyService;
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
//		model.put("name", name);		
//		System.out.println("name is " + name);
		return "login";
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public String showWelcomePage(@RequestParam String name_html, @RequestParam String password_html, ModelMap model) {
		boolean isValidUser = service.validateUser(name_html, password_html);
		boolean isRealValidUser=dummyService.isValidate(name_html, password_html);

		if (!isValidUser) {
			
			if (!isRealValidUser) {
				model.put("errorMessage", "both invalid credentials");
				return "login";
			}
			model.put("errorMessage", "invalid credentials 28min");
			return "login";
		}
			
		if (!isRealValidUser) {
			model.put("errorMessage", "invalid credentials dummy");
			return "login";
		}
		
//		model.put("name", name_html);		
//		model.put("password", password_html);	
//		System.out.println("name is " + name);
		return "welcome";
	}
	
	@RequestMapping("/hallo")
	@ResponseBody			// format html
	public String helloMessage() {
		return "Hello World";
	}
	
	@RequestMapping("/calculate")
	public String calculateMessage(@RequestParam int param1, @RequestParam int param2, ModelMap model2) {
		model2.put("param1", param1);
		model2.put("param2", param2);
		System.out.println("result is " + param1 + param2);
		int result = param1 + param2; model2.put("result", result);
		return "calculate";
	}
	
	@RequestMapping("/login_old")
	public String loginMessage_old(@RequestParam String name, ModelMap model) {
		model.put("name", name);		
		System.out.println("name is " + name);
		return "login_old";
	}
	
}
