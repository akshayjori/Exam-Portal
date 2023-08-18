package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.model.Question;
import com.cognizant.model.services.Util;
import com.cognizant.model.services.SearchQuesService;
import com.cognizant.model.services.UpdateQuesService;

@Controller
@SessionAttributes("quesList")
public class SearchQuesController {
	public String subj;
	@Autowired
	Util cServices;

	// returns subjectList
	@ModelAttribute("subjectList")
	public List<String> populateSubjectList() {
		List<String> subjectList = Util.getSubjectsArray();
		return subjectList;
	}

	@RequestMapping(value = "/searchQues", method = RequestMethod.GET)
	public String showSubject(@RequestParam String subject, ModelMap m) {
		List<Question> quesList = SearchQuesService.showQuestions(subject.replaceAll("[^a-zA-Z0-9]", ""));
		m.addAttribute("quesList", quesList);
		m.addAttribute("subject", subject);
//		m.addAttribute("subjectList", populateSubjectList());
		return "searchQues";
	}

	@RequestMapping(value = "/searchQues", method = RequestMethod.POST)
	public String showQuestions(@RequestParam String subject, ModelMap m) {
		List<Question> quesList = SearchQuesService.showQuestions(subject.replaceAll("[^a-zA-Z0-9]", ""));
		m.addAttribute("quesList", quesList);
		m.addAttribute("subject", subject);
		return "searchQues";
	}

	@RequestMapping(value = "/deleteQues", method = RequestMethod.GET)
	public String deleteQuestion(@RequestParam int questionId, ModelMap m) {
		Question ques= UpdateQuesService.showSelectedQuesDetails(questionId);
//		System.out.println("In deleteQues=======> "+ques);
		UpdateQuesService.deleteQuestion(ques);
		
		return "redirect:searchQues?subject=" + ques.getSubject();
	}
}
