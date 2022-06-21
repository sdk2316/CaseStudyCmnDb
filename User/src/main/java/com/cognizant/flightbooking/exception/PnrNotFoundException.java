package com.cognizant.flightbooking.exception;

public class PnrNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;

	public PnrNotFoundException(){
		
	}
	public PnrNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
