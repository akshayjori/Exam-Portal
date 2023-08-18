package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.Question;
import com.cognizant.model.services.AddQuesService;
import com.cognizant.model.services.Util;

@Controller
public class AddQuesController {

	@Autowired
	AddQuesService addQuesService;
	@Autowired
	Util cServices;

	// to auto-populate subjects in addExam form
	@ModelAttribute("subjectList")
	public List<String> populateProductType() {
		return Util.getSubjectsArray();
	}

	@RequestMapping(value = "/addQues", method = RequestMethod.GET)
	public String handleForm(@ModelAttribute Question question) {
		return "addQues";
	}

	@RequestMapping(value = "/addQues", method = RequestMethod.POST)
	public String showDesc1(@ModelAttribute Question question, ModelMap m) {

		if (addQuesService.chechIfQuestionExists(question)) {
			m.addAttribute("status", "We already have this Question in our database");
		} else if (addQuesService.addQuestion(question)) {
			m.addAttribute("status", "Question added sucessfully");
		} else {
			m.addAttribute("status", "Something went wrong!!!");
		}
		return "addQues";
	}

}
