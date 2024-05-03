package com.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.entity.User;
import com.tunehub.service.UserService;

import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	UserService us;

	@PostMapping("/register")
	
	
	public String addUser(@ModelAttribute User user) {
		System.out.println(user);
		User userExists = us.emailExists(user);
		if(userExists==null) {
		us.saveUser(user);
		System.out.println("User added successfully");
	}
		else {
			System.out.println("Duplicate User");
		}
		
		return "login";
}
	
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session) {
		
		if(us.validUser(email,password)==true) {
			session.setAttribute("email", email);
			String role=us.getRole(email);
			System.out.println(email+" - "+password +" Login");
			
			if(role.equals("Admin")) {
				return "AdminHome";
			}
			else {
				return "CustomerHome";
			}
			
		}
		else
		return "login";	

}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 session.invalidate();
		return "login";
	}
	}

	


