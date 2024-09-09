package com.harmanLabs.springboot.mywebapp.loginAuthenticationService;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String username, String password) {
		
		boolean isValidUsername=username.equalsIgnoreCase("harmanlabs");
		boolean isValidPassword=password.equalsIgnoreCase("dummy");
		
		return isValidUsername && isValidPassword;
	}
	
	
}
