package com.cognizant.flightbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FlightNotFoundException {
	
	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<String> handleCompanyNotFoundException(){
		
		return new ResponseEntity<String>("Flight Not Found",HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value=FillCompleteFormException.class)
	public ResponseEntity<String> handleFillCompleteFormException(){
		
		return new ResponseEntity<String>("Form should not be blank ",HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value=UsernameNotFoundException.class)
	public ResponseEntity<String> handleUsernameNotFoundException(){
		
		return new ResponseEntity<String>("User Not exist ",HttpStatus.NOT_FOUND);
		
	}

}
