package com.cognizant.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cognizant.controller.wrapper.GenerateReportWrapper;
import com.cognizant.controller.wrapper.ReportWrapper;
import com.cognizant.model.services.GenerateReportService;

@Controller
public class GenerateReportController {

	@ModelAttribute("examCodesList")
	public List<String> pupulateExamCodes() {
		List<String> examCodesList = GenerateReportService.examCodesList();
		return examCodesList;
	}

	@RequestMapping(value = "/generateReport", method = RequestMethod.GET)
	public String showDesc(@ModelAttribute("wrapper") GenerateReportWrapper wrapper, ModelMap m) {
		return "generateReport";
	}

	@RequestMapping(value = "/generateReport", method = RequestMethod.POST)
	public String showDesc2(@ModelAttribute("wrapper") GenerateReportWrapper wrapper, ModelMap m) {
		List<ReportWrapper> wr=GenerateReportService.report(wrapper);
		m.addAttribute("wr", wr);
		System.out.println(wrapper);
		return "generateReport";
	}
	
}
