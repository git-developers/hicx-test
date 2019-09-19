package com.hicx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	
	@RequestMapping("/welcome")
	public ModelAndView welcome() {
 
		String message = "welcome message";
		return new ModelAndView("welcome", "message", message);
	}
	
}
