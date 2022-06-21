package com.cognizant.flightbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.flightbooking.entity.BookFlight;
import com.cognizant.flightbooking.repo.BookFlightRepo;

@Service
public class BookFlightImpl implements IBookFlight{
	
	@Autowired
	private BookFlightRepo bookFlightRepo;
	
	@Override
	public BookFlight bookFlight(BookFlight bookFlight) {
		// TODO Auto-generated method stub
		return bookFlightRepo.save(bookFlight);
	}

}
