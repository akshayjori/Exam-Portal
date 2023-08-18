package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.model.Ticket;
import com.cognizant.model.services.UserHelpService;

@Controller
public class UserHelpController {

	@Autowired
	UserHelpService userhelpservice;

	@RequestMapping(value = "/userIssue", method = RequestMethod.GET)
	public String raiseTechIssue(@ModelAttribute("ticket") Ticket ticket, @RequestParam int userId , ModelMap m) {
		
		List<Ticket> ticketList = userhelpservice.getTicketDetails(userId);
		m.addAttribute("ticketList", ticketList);
		m.addAttribute("userId" , userId);
		return "userIssue";
	}

	@RequestMapping(value = "/userIssue", method = RequestMethod.POST)
	public String showTechIssue(@ModelAttribute("ticket") Ticket ticket, Model m, @RequestParam int userId) {

		m.addAttribute("userId", userId);
	
			
            userhelpservice.reportIssue(ticket);
			//List<Ticket> ticketList = userhelpservice.getTicketDetails(userId);

			//m.addAttribute("ticketList", ticketList);
			return "redirect:userIssue?userId="+userId;
	

	}

}
