package com.cognizant.flightbooking.exception;

public class EmailIdNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public EmailIdNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public EmailIdNotFoundException() {
		
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	

}
