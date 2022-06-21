package com.cognizant.flightbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.flightbooking.entity.BookFlight;
import com.cognizant.flightbooking.exception.PnrNotFoundException;
import com.cognizant.flightbooking.exception.ResourceNotFoundException;
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

	@Override
	public List<BookFlight> getAllBookFlight() {
		// TODO Auto-generated method stub
		return  bookFlightRepo.findAll();
	}

	@Override
	public void cancelBookFlight(Integer id) {
		
		try {
			 bookFlightRepo.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new PnrNotFoundException("PNT Not Found "+id);
		}
		
	}

	@Override
	public BookFlight getFlightByPnr(Integer id) {
		try {
			return  bookFlightRepo.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			throw new PnrNotFoundException("PNT Not Found "+id);
		}
	}

	@Override
	public List<BookFlight> getByEmail(String email) {
		try {
			return  bookFlightRepo.findByEmail(email);
		} catch (Exception e) {
			// TODO: handle exception
			throw new PnrNotFoundException("Email Not Found "+email);
		}
	}

	

}
