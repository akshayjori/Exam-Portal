package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.controller.wrapper.UpdatePasswordWrapper;
import com.cognizant.model.services.UpdatePasswordService;

@Controller
public class UpdatePasswordController {

	@Autowired
	UpdatePasswordService updatepasswordservice;;

	@RequestMapping(value = "/updatepassword", method = RequestMethod.GET)
	public String showUpdatePasswordPage(
			@ModelAttribute("updatepasswordwrapper") UpdatePasswordWrapper updatepasswordwrapper) {
		return "updatepassword";

	}

	@RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
	public String UpdatePasswordPage(
			@ModelAttribute("updatepasswordwrapper") UpdatePasswordWrapper updatepasswordwrapper, ModelMap m) {
		if (updatepasswordservice.checkBothPassword(updatepasswordwrapper)) {
			if (updatepasswordservice.updateNewPassword(updatepasswordwrapper)) {
				m.addAttribute("message", "Your password has been updated <br>"
						+ "<a class=\"text-primary\" href=\"/login\">Go to Login page</a>");
			} else {
				m.addAttribute("error1", "Something Went Wrong");
			}

			return "updatepassword";
		} else {
			m.addAttribute("error2", "Both passwords should be matched <br> Enter confirm password Again");
			return "updatepassword";
		}

	}

}
