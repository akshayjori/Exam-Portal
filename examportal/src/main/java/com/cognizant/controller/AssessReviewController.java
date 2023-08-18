package com.cognizant.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.controller.wrapper.AssessDetailsWrapper;
import com.cognizant.model.Feedback;
import com.cognizant.model.services.AddFeedbackService;

@Controller
@SessionAttributes("userId")
public class AssessReviewController {

	@RequestMapping(value = "/assessReview", method = RequestMethod.GET)
	public String showAssessments(@RequestParam int userId, ModelMap m) {
		m.addAttribute("userId", userId);
		List<AssessDetailsWrapper> assessWrapper = AddFeedbackService.showAssessments(userId);
		m.addAttribute("assessWrapper", assessWrapper);
		List<AssessDetailsWrapper> givenFeedbackList = AddFeedbackService.showGivenFeedbacks(userId);
		m.addAttribute("givenFeedbackList", givenFeedbackList);
		return "assessReview";
	}

	@RequestMapping(value = "/giveFeedback", method = RequestMethod.GET)
	public String giveFeedback(@ModelAttribute("feedback") Feedback feedback, @RequestParam int attemptId, ModelMap m) {
		m.addAttribute("attemptId", attemptId);
		return "giveFeedback";
	}

	@RequestMapping(value = "/giveFeedback", method = RequestMethod.POST)
	public String giveFeedback2(@ModelAttribute("feedback") Feedback feedback, @RequestParam int attemptId,
			ModelMap m) {
		m.addAttribute("attemptId", attemptId);
		if (AddFeedbackService.addFeedback(attemptId, feedback.getFeedback())) {
			int userId = (int) m.getAttribute("userId");
			m.addAttribute("status",
					"Submitted!!<br> <a href=\"/assessReview?userId=" + userId + "\">Give another feedback</a>");
		} else
			m.addAttribute("status", "Something went wrong!!!");
		return "giveFeedback";
	}

}
