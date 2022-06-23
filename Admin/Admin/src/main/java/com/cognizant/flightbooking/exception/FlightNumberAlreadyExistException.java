package com.cognizant.flightbooking.exception;

public class FlightNumberAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public FlightNumberAlreadyExistException(String message) {
		super();
		this.message = message;
	}
	
	public FlightNumberAlreadyExistException() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
