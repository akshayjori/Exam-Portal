package com.cognizant.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.controller.wrapper.SearchExamWrapper;
import com.cognizant.model.Exam;
import com.cognizant.model.services.ExamService;
import com.cognizant.model.services.UpdateExamDetailsService;
import com.cognizant.model.services.Util;

@Controller
public class UpdateExamController {

	@Autowired
	private ExamService examService;

	@RequestMapping(value = "/searchExamDetails", method = RequestMethod.GET)
	public String beginExamSearch(@ModelAttribute("wrapper") SearchExamWrapper wrapper, @RequestParam String searchWord,
			Model model) {
		searchWord= searchWord.replaceAll("[^a-zA-Z0-9]", "");
		ArrayList<Exam> examsList = examService.searchExams(searchWord);
		model.addAttribute("examsList", examsList);
		return "searchExamDetails";
	}

	@RequestMapping(value = "/searchExamDetails", method = RequestMethod.POST)
	public String afterSearchExamDetails(@ModelAttribute("wrapper") SearchExamWrapper wrapper, Model model) {
		ArrayList<Exam> examsList = examService.searchExams(wrapper.getSearchWord());
		model.addAttribute("examsList", examsList);
		return "searchExamDetails";
	}

	@RequestMapping(value = "/deleteExam", method = RequestMethod.GET)
	public String deleteQuestion(@RequestParam String examcode, ModelMap m) {
		Exam exam = UpdateExamDetailsService.showSelectedExamDetails(examcode);
		UpdateExamDetailsService.deleteExam(exam);

		return "redirect:searchExamDetails?searchWord=" + "";
	}

	@RequestMapping(value = "/updateExamDetails", method = RequestMethod.GET)
	public String showExam(@ModelAttribute("exam") Exam exam, @RequestParam String examcode, ModelMap m) {
		System.out.println("after clicking update exam ======>>>" + exam);
		m.addAttribute("oldExamCode", examcode);
		Exam examOld = UpdateExamDetailsService.showSelectedExamDetails(examcode);
		m.addAttribute("exam1", examOld);
		m.addAttribute("subjectList", Util.getSubjectsArray());
		return "updateExamDetails";
	}

	@RequestMapping(value = "/updateExamDetails", method = RequestMethod.POST)
	public String showUpdateStatus(@ModelAttribute("exam") Exam exam, ModelMap m, @RequestParam String oldExamCode) {
		System.out.println("after clicking update exam ======>>>" + exam);
		if (UpdateExamDetailsService.updateExamDetails(exam, oldExamCode)) {
			m.addAttribute("status", "Exam updated sucessfully!! <br> <a href=\"searchExamDetails?searchWord="
					+ exam.getSubject().replaceAll("[^a-zA-Z0-9]", "") + "\">Update another Exam</a>");
		} else {
			m.addAttribute("status", "Something went wrong!!");
		}
		m.addAttribute("subjectList", Util.getSubjectsArray());
		return "updateExamDetails";
	}

}
