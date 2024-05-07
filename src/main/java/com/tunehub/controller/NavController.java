package com.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/login")
	public String login() {
		return "login";
	} 
	@GetMapping("/registration")
	public String registration() {
		return "Registration";
	}

//	@GetMapping("/home")
//	public String home() {
//		return "home";
//	}
	
	@GetMapping("/addsongs")
	public String song() {
		return "Song"; 
	}
	@GetMapping("/forgotpassword")
	public String forgotPassword() {
		return "forgotpassword";
	}
	
}
	
	
	
	


