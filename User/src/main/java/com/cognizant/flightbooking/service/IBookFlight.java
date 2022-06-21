package com.cognizant.flightbooking.service;

import java.util.List;

import com.cognizant.flightbooking.entity.BookFlight;

public interface IBookFlight {
	
	
	BookFlight bookFlight(BookFlight bookFlight);
	
	List<BookFlight> getAllBookFlight();
	
	void cancelBookFlight(Integer id);
	
	BookFlight getFlightByPnr(Integer id);
	
	List<BookFlight> getByEmail(String email);
	
	
}
