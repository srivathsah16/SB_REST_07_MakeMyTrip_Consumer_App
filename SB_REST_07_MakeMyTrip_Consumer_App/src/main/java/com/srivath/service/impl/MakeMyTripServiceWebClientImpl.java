package com.srivath.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.srivath.binding.Passenger;
import com.srivath.binding.Ticket;
import com.srivath.service.MakeMyTripService;

@Service("WebClientImpl")
public class MakeMyTripServiceWebClientImpl implements MakeMyTripService {

	// URLs of Provider REST APIs operations
	private String BOOK_TICKET_URL = "http://localhost:8080/ticket";
	private String GET_TICKET_URL = "http://localhost:8080/ticket/{ticketNum}";

	@Override
	public Ticket bookTicket(Passenger passenger) {
		System.out.println("WebClientImpl bookTicket triggered..");
		// creating an instance of Implementation class of WebClient Interface
		WebClient client = WebClient.create();
		Ticket ticket = client.post()
							.uri(BOOK_TICKET_URL)
							.bodyValue(passenger)
							.retrieve()
							.bodyToMono(Ticket.class)
							.block(); //sync call - means wait till the response is received.
		return ticket;
	}

	@Override
	public Ticket geTicketByNumber(Integer ticketNumber) {
		System.out.println("WebClientImpl geTicketByNumber triggered..");
		WebClient client = WebClient.create();
		Ticket ticket = client.get()
							.uri(GET_TICKET_URL, ticketNumber) 
							.retrieve()
							.bodyToMono(Ticket.class)
							.block(); //making it a sync call	
		return ticket;
		
	}
}
