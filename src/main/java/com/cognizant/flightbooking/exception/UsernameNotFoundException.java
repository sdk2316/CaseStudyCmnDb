package com.cognizant.flightbooking.exception;

public class UsernameNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public UsernameNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public UsernameNotFoundException() {
		
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
