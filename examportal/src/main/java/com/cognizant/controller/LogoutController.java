package com.cognizant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.User;

@Controller
public class LogoutController {

	// show this page at start
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String loginPageGet(@ModelAttribute User user) {
		user = null;
		return "redirect:login";
	}
}
