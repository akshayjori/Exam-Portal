package com.cognizant.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.Exam;
import com.cognizant.model.services.Util;
import com.cognizant.model.services.ExamService;

@Controller
public class AddExamController {

	@Autowired
	ExamService examservice;
	@Autowired
	Util cServices;
	
	// to auto-populate subjects in addExam form
	@ModelAttribute("subjectList")
	public List<String> populateProductType() {
		return Util.getSubjectsArray();
	}

	@GetMapping(value = "/addexam")
	public String showDesc(@ModelAttribute("exam") Exam exam) {
		return "addexam";
	}

	@RequestMapping(value = "/addexam", method = RequestMethod.POST)
	public String showDesc1(@ModelAttribute("exam") Exam exam, ModelMap m) {

		if (examservice.checkForExistingExamCode(exam)) {
			m.addAttribute("status", "We already have this Examcode <br>Use different one");
		} else if (examservice.addExamDetails(exam)) {
			m.addAttribute("status", "Exam details added sucessfully");
		} else {
			m.addAttribute("status", "Something went wrong!!!");
		}
		return "addexam";
	}

}
