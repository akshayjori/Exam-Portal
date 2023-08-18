package com.cognizant.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.services.GrphicalReportServices;

@Controller
public class GraphicalReportController {
	
	@RequestMapping(value="graphicalReport", method=RequestMethod.GET)
	public String graphicalReport(Model m) {
		Map<String, Integer> attemptsMap= GrphicalReportServices.getAllExamAttempts();
		m.addAttribute("attemptsMap", attemptsMap);
		return "graphicalReport";
	}
}
