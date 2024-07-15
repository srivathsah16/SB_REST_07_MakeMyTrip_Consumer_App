package com.srivath.binding;

import lombok.Data;

@Data
public class Ticket {

	private Integer ticketNumber;
	private Double cost;
	private String status;
	private String name;
	private String from;
	private String to;
	private String doj;
	private String trainNumber;
}
