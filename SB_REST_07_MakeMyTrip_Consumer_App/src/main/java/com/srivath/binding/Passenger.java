package com.srivath.binding;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Passenger {
	
	@NotBlank(message = "Name is mandaory")
	private String name;
	@NotBlank(message = "From is mandaory")
	private String from;
	@NotBlank(message = "To is mandatory")
	private String to;
	@NotBlank(message = "Please select your Date of Journet")
	private String doj;
	@NotBlank(message = "Train Number is mandaory")
	private String trainNumber;
}
