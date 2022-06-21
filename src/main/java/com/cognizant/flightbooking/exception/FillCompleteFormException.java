package com.cognizant.flightbooking.exception;

public class FillCompleteFormException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public FillCompleteFormException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public FillCompleteFormException() {
		
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
