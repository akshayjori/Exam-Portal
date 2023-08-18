package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.controller.wrapper.GetUserName;
import com.cognizant.model.services.GetUserNameService;

@Controller
public class RecoverUserNameController {
	@Autowired
	GetUserNameService getusernameservice;

	@RequestMapping(value = "/recoverusername", method = RequestMethod.GET)
	public String showGetLoginPage(@ModelAttribute("getusername") GetUserName getusername) {
		return "forgotusername";
	}

	@RequestMapping(value = "/recoverusername", method = RequestMethod.POST)
	public String showGetLogin(@ModelAttribute("getusername") GetUserName getusername, ModelMap m) {

		String uname = getusernameservice.showUserName(getusername);
		if (uname.equalsIgnoreCase("")) {
			m.addAttribute("error" , "Provided information is Incorrect !!");
			return "forgotusername";
		} else {
			m.addAttribute("uname", uname);

			return "showusername";
		}
	}

}
