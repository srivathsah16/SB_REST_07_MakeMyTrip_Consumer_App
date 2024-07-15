package com.srivath.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.srivath.binding.Passenger;
import com.srivath.binding.Ticket;
import com.srivath.service.MakeMyTripService;

@Service("RestTemplateImpl")
public class MakeMyTripServiceRestTemplateImpl implements MakeMyTripService {

	// URLs of Provider REST APIs operations
	private String BOOK_TICKET_URL = "http://localhost:8080/ticket";
	private String GET_TICKET_URL = "http://localhost:8080/ticket/{ticketNum}";

	@Override
	public Ticket bookTicket(Passenger passenger) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
		Ticket ticket = responseEntity.getBody();
		return ticket;
	}

	@Override
	public Ticket geTicketByNumber(Integer ticketNumber) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> respEntity = rt.getForEntity(GET_TICKET_URL, Ticket.class, ticketNumber);
		return respEntity.getBody();
	}
}
