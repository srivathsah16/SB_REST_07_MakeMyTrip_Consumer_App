package com.srivath.service;

import com.srivath.binding.Passenger;
import com.srivath.binding.Ticket;

public interface MakeMyTripService {
	public Ticket bookTicket(Passenger passenger);
	public Ticket geTicketByNumber(Integer ticketNumber);
}
