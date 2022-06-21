package com.cognizant.flightbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FlightNotFoundException {
	
	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<String> handleCompanyNotFoundException(){
		
		return new ResponseEntity<String>("Flight Not Found",HttpStatus.BAD_REQUEST);
		
	}

}
