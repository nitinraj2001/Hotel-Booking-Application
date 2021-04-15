package com.nitinraj.hotelbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nitinraj.hotelbooking.model.Users;

@Controller
@RequestMapping("/")
public class DefaultController {
	
	
	@RequestMapping("/")
	public String redirectHome() {
		return "home-page";
	}
	
	@GetMapping("/about")
	public String redirectAboutPage() {
		return "about-page";
	}

	@GetMapping("/login")
	public String redirectloginPage() {
		return "login-page";

	}
	
	@GetMapping("/register")
	public String redirectRegisterPage(Model theModel) {
		
		Users theUser=new Users();
		//UserProfile theUserProfile=new UserProfile();
		
		theModel.addAttribute("user", theUser);
		
		//theModel.addAttribute("userprofile", theUserProfile);
		
		return "register-page";
	}

	
	

}
