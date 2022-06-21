package com.cognizant.flightbooking;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FlightBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingApplication.class, args);
	}

	
	@Bean
	public ModelMapper  modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
}
