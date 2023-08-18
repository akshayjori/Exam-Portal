package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.controller.wrapper.GetPassword;
import com.cognizant.model.services.GetPasswordService;

@Controller
public class RecoverPasswordController {
	
	@Autowired 
	GetPasswordService getpasswordservice;
	
	@RequestMapping(value="/recoverpassword" , method=RequestMethod.GET)
	public String showForgotPasswordPage(@ModelAttribute("getpassword") GetPassword getpassword) {
		return "forgotpassword";
	}
	
	@RequestMapping(value="/recoverpassword" , method=RequestMethod.POST)
	public String updatePassword(@ModelAttribute("getpassword") GetPassword getpassword , ModelMap m) {
		
		if(getpasswordservice.getPassWord(getpassword)) {
			 
			return "redirect:/updatepassword";
		}
		else {
			m.addAttribute("error","Provided information is Incorrect !!");
			return "forgotpassword";
		}
		
	}

}
