package com.srivath.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.srivath.binding.Passenger;
import com.srivath.binding.Ticket;
import com.srivath.service.MakeMyTripService;

import jakarta.validation.Valid;

@Controller
public class MakeMyTripController {

	@Autowired
	@Qualifier("WebClientImpl")
	private MakeMyTripService service;

	@GetMapping("/")
	public String loadForm(Model model) {
		System.out.println("req came to home");
		model.addAttribute("passenger", new Passenger());
		return "index";
	}

	@PostMapping("/bookTicket")
	public String bookTicket(@Valid @ModelAttribute("passenger") Passenger passenger, BindingResult result, Model model) {
		System.out.println(passenger);
		if (result.hasErrors()) {
			return "index";
		}
		Ticket ticket = service.bookTicket(passenger);
		model.addAttribute("msg",
				"Ticket booked successfully. Your ticket number is " + ticket.getTicketNumber());
		return "index";
	}

	@GetMapping("/getTicket")
	public String loadGetTicketPage(Model model) {
		System.out.println("loadGetTicketPage triggered....");
		model.addAttribute("ticket", new Ticket());
		return "ticket";
	}

	@GetMapping("/fetchTicket")
	public String fetchTicket(@RequestParam("ticketNum") Integer ticketNumber, Model model) {
		System.out.println("ticketNumber = " + ticketNumber);
		Ticket ticket = service.geTicketByNumber(ticketNumber);
		if (ticket != null) {
			model.addAttribute("ticket", ticket);
		} else {
			model.addAttribute("ticket", new Ticket());
			model.addAttribute("msg", "Invalid ticket number. Please enter valid number.");
		}
		return "ticket";
	}

}
