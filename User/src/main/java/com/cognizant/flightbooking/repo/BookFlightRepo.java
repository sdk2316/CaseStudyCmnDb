package com.cognizant.flightbooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.flightbooking.entity.BookFlight;

public interface BookFlightRepo extends JpaRepository<BookFlight, Integer>{
	
	List<BookFlight> findByEmail(String email);
	

}
