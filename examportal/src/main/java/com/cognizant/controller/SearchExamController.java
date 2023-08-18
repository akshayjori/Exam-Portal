package com.cognizant.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.controller.wrapper.SearchExamWrapper;
import com.cognizant.model.Exam;
import com.cognizant.model.services.ExamService;

@Controller
@SessionAttributes("userId")
public class SearchExamController {
	
	@Autowired
	private ExamService examService;

	@RequestMapping(value = "/searchexam", method = RequestMethod.GET)
	public String beginSearch(@ModelAttribute("wrapper") SearchExamWrapper wrapper, Model model, @RequestParam int userId) {
		model.addAttribute("userId", userId);
		
//		System.out.println("Search Exam Entering ======> UserId: "+model.getAttribute("userId"));
		
		return "searchexam";
	}
	
	@RequestMapping(value = "/searchexam", method = RequestMethod.POST)
	public String afterSearch(@ModelAttribute("wrapper") SearchExamWrapper wrapper, Model model) {
		model.addAttribute("userId", model.getAttribute("userId"));
		
//		System.out.println("Search Exam ======> UserId: "+model.getAttribute("userId"));
		
		ArrayList<Exam> examsList= examService.searchExams(wrapper.getSearchWord());
		model.addAttribute("searchStatus", wrapper.getSearchWord());
		model.addAttribute("examsList", examsList);
		return "searchexam";
	}
	
}
