package com.cognizant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.model.Exam;
import com.cognizant.model.ExamAttemptQuestion;
import com.cognizant.model.User;
import com.cognizant.model.services.Util;

@Controller
public class CertificateController {

	@RequestMapping(value="certificate", method= RequestMethod.GET)
	public String getCertificate(@RequestParam int userId, @RequestParam("attemptId") int attemptId, Model m) {
		User user= Util.getUserById(userId);
		ExamAttemptQuestion exQuestion= Util.getExamAttemptQByAttemptId(attemptId);
		Exam exam= Util.getExamDetails(exQuestion.getExamCode());
		
		m.addAttribute("user", user);
		m.addAttribute("exQuestion", exQuestion);
		m.addAttribute("exam", exam);
		m.addAttribute("attDate", Util.utilDateToString(exQuestion.getAttemptDate()));
		
		return "certificate";
	}
}
