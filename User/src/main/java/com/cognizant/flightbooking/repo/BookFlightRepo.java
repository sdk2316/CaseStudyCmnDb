package com.cognizant.flightbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.flightbooking.entity.BookFlight;

public interface BookFlightRepo extends JpaRepository<BookFlight, Integer>{

}
