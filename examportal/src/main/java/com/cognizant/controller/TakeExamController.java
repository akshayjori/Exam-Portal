package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.controller.wrapper.ExamAttemptWrapper;
import com.cognizant.model.ExamAttemptQuestion;
import com.cognizant.model.Question;
import com.cognizant.model.User;
import com.cognizant.model.services.ExamAttemptServices;
import com.cognizant.model.services.FeedbackServices;
import com.cognizant.model.services.Util;

@Controller
@SessionAttributes("examCode")
public class TakeExamController {

	@Autowired
	private ExamAttemptServices service;

	@RequestMapping(value = "/takeexam", method = RequestMethod.GET)
	public String examPage(@ModelAttribute("wrapper") ExamAttemptWrapper wrapper, @RequestParam String examCode,
			Model model, @RequestParam int userId) {
		model.addAttribute("userId", userId);
		List<Question> questionsList = Util.getQuestionsByExamCode(examCode);
		model.addAttribute("questionsList", questionsList);
		model.addAttribute("examCode", examCode);
		return "takeexam";
	}

	@RequestMapping(value = "/showresult", method = RequestMethod.POST)
	public String examPage(@ModelAttribute("wrapper") ExamAttemptWrapper wrapper, Model m) {
		System.out.println("Returned wrapper:=========> " + wrapper);

		int attemptId = service.getAttemptId(); // done
		FeedbackServices.insertAttemptIdToFeedbackTable(attemptId);
		int correctAnswers = 0; // done*
		int unAnswered = 0; // done*
		int totalMarks = 0; // done*
		int obtainedMarks = 0; // done*
		int percentage = 0; // done*

		// calculating data
		for (ExamAttemptQuestion ex : wrapper.getExamAttemptQuestions()) {

			totalMarks += ex.getMarks();
			// setting attemptId
			ex.setAttemptId(attemptId);

			// setting responseStatus
			// increasing unAnswered
			if (ex.getResponse() != null) {
				// setting isCorrect
				// increasing correctAnswers
				if (ex.getResponse().equals(ex.getAnswer())) {
					ex.setIsCorrect(true);
					correctAnswers++;
					obtainedMarks += ex.getMarks();
				} else {
					ex.setIsCorrect(false);
				}
				ex.setResponseStatus("Answered");
			} else {
				ex.setResponseStatus("UnAnswered");
				unAnswered++;
			}

		}

		percentage = (int) (((double) obtainedMarks / totalMarks) * 100.0);

		// inserting data to database
		for (ExamAttemptQuestion ex : wrapper.getExamAttemptQuestions()) {
			ex.setScore(percentage);
			service.insertExamAttempt(ex);
		}

		User user = Util.getUserById(wrapper.getExamAttemptQuestions().get(0).getUserId());

		// creating attributes for resultpage
		m.addAttribute("user", user);
		m.addAttribute("score", percentage);
		m.addAttribute("correctAnswers", correctAnswers);
		m.addAttribute("unAnswered", unAnswered);
		m.addAttribute("attemptId", attemptId);

		return "showResult";
	}

}
