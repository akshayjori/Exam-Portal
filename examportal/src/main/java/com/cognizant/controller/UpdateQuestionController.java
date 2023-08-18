package com.cognizant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cognizant.model.Question;
import com.cognizant.model.services.UpdateQuesService;
import com.cognizant.model.services.Util;

@Controller
public class UpdateQuestionController {

	@RequestMapping(value = "/updateQues", method = RequestMethod.GET)
	public String showSubject(@ModelAttribute("ques") Question ques, @RequestParam int questionId, ModelMap m) {
		m.addAttribute("questionId", questionId);
		Question quesOld = UpdateQuesService.showSelectedQuesDetails(questionId);
//		System.out.println("Before clicking Update =====> "+ques);
		m.addAttribute("ques1", quesOld);
		m.addAttribute("subjectList", Util.getSubjectsArray());
		return "updateQues";
	}

	@RequestMapping(value = "/updateQues", method = RequestMethod.POST)
	public String showUpdateStatus(@ModelAttribute("ques") Question ques, ModelMap m) {
//		System.out.println("After clicking Update =====> " + ques);

		if (UpdateQuesService.updateSelectedQuesDetails(ques))
			m.addAttribute("status", "Question updated sucessfully!! <br> <a href=\"searchQues?subject="
					+ ques.getSubject() + "\">Update another question</a>");
		else
			m.addAttribute("status", "Something went wrong!!");

		return "updateQues";
	}

}
