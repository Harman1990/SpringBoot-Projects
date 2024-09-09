package com.harmanLabs.springboot.mywebapp.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.harmanLabs.springboot.mywebapp.loginAuthenticationService.AuthenticationService;

@Controller
public class LoginController {

	private AuthenticationService authenticationService;
	
	
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String gotoLoginPage() {
		
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
		
		model.put("name", name);
		model.put("password", password);
		return "welcome";
		
		}
		else {
			String error_msg="Invalid Credentials! Please try again";
			model.put("errorMessage", error_msg);
			return "login";
		}
		
		
		
		
	}
	
	
	
}
