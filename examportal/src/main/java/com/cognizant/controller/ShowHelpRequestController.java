package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.model.Ticket;
import com.cognizant.model.services.ShowHelpRequestService;

@Controller
public class ShowHelpRequestController {

	@Autowired
	ShowHelpRequestService showhelprequest;

	@RequestMapping(value = "/showHelpRequest", method = RequestMethod.GET)
	public String helpRequestPage(@ModelAttribute("ticket") Ticket ticket, ModelMap m) {
		List<Ticket> showallticket = showhelprequest.getTicketDetails(ticket);
		m.addAttribute("showallticket", showallticket);

		return "showHelpRequest";
	}

	@RequestMapping(value = "/solveTicket", method = RequestMethod.GET)
	public String showRequestPage(@ModelAttribute("ticket") Ticket ticket, ModelMap m, @RequestParam int ticketId) {
		
		List<Ticket> showeachticket = showhelprequest.getEachTicketDetails(ticketId);

		m.addAttribute("showeachticket", showeachticket);

		return "resolveRequest";
	}
	
	@RequestMapping(value = "/solveTicket", method = RequestMethod.POST)
	public String solveRequest(@ModelAttribute("ticket") Ticket ticket, ModelMap m, @RequestParam int ticketId) {
		
		boolean ans = showhelprequest.solveTicket(ticket);
		if(ans) {
			return "redirect:showHelpRequest";
		}
		else {
			return "false";
		}
		
		
	}


}
