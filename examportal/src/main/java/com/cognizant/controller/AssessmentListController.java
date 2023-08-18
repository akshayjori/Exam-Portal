package com.cognizant.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.controller.wrapper.AssessDetailsWrapper;
import com.cognizant.model.services.AssessmentListServices;

@Controller
public class AssessmentListController {

	@RequestMapping(value = "/assessmentList", method = RequestMethod.GET)
	public String showDesc(@RequestParam int userId, ModelMap m) {
		m.addAttribute("userId", userId);
		List<AssessDetailsWrapper> assessWrapper = AssessmentListServices.getAllAssessments(userId);
		m.addAttribute("assessWrapper", assessWrapper);
		return "assessmentList";
	}
}
