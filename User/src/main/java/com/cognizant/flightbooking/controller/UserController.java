package com.cognizant.flightbooking.controller;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.flightbooking.entity.AddFlightDetails;
import com.cognizant.flightbooking.entity.BookFlight;
import com.cognizant.flightbooking.exception.FillCompleteFormException;
import com.cognizant.flightbooking.exception.ResourceNotFoundException;
import com.cognizant.flightbooking.payload.UserInfo;
import com.cognizant.flightbooking.service.BookFlightImpl;
import com.cognizant.flightbooking.service.IAddFlightService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user/api/v1.0")
@Api(tags = { "Flight User Booking RestApi" }, description = " ")

//http://localhost:9090/swagger-ui.html
public class UserController {

	@Autowired
	private BookFlightImpl bookFlights;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IAddFlightService flightService;

	// http://localhost:9094/search/{fromPlace}/{toPlace}/{startDate}
	// http://localhost:9090/user/api/v1.0/search/MUM/PATNA/2022-05-30
	@GetMapping("/search/{fromPlace}/{toPlace}/{startDate}")
	public List<?> findByfromPlaceAndtoPlace(@PathVariable("fromPlace") String fromPlace,
			@PathVariable("toPlace") String toPlace,
			@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate) {
		List<AddFlightDetails> fromPlaceAndtoPlace = null;

		try {
			if (fromPlace != null && toPlace != null) {
				fromPlaceAndtoPlace = flightService.searchFlight(fromPlace, toPlace, startDate);
				if (fromPlaceAndtoPlace.size() == 0) {
					throw new ResourceNotFoundException();
				}
				System.out.println(fromPlaceAndtoPlace);

				return fromPlaceAndtoPlace;
			} else {
				throw new ResourceNotFoundException();
			}

		} catch (Exception e) {
			e.printStackTrace();

			throw new ResourceNotFoundException(
					"Unable to fetch resource from " + fromPlace + " toPlace " + toPlace + " journeyDate " + startDate);

		}

		// return fromPlaceAndtoPlace;

	}

	@PostMapping("/bookFlight")
	public ResponseEntity<?> bookFlight(@RequestBody UserInfo userInfo) {

		// convert DTO to entity

		BookFlight bookFlight = modelMapper.map(userInfo, BookFlight.class);
		BookFlight book = bookFlights.bookFlight(bookFlight);

		// convert entity to DTO

		UserInfo userInput = modelMapper.map(book, UserInfo.class);
		return new ResponseEntity<>("Your Ticket book succesfully..  PNR number is : "+userInput.getId(), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllBookFlight")
	public List<BookFlight> getAllBookFlight(){
		
		return bookFlights.getAllBookFlight();
	}
	
	@GetMapping("/getFlightByPnr/{id}")
public ResponseEntity<BookFlight> getFlightByPnr(@PathVariable Integer id){
		
		ResponseEntity<BookFlight> resp=null;
		try {
			BookFlight flightByPnr = bookFlights.getFlightByPnr(id);
			resp=ResponseEntity.ok(flightByPnr);
		} catch (Exception e) {
			 resp=new ResponseEntity<BookFlight>(HttpStatus.NOT_FOUND);
			 e.printStackTrace();
		}
		return resp;
	}
	
	
	@GetMapping("/getFlightByEmailId/{email}")
	public ResponseEntity<List<BookFlight>> getFlightByEmailId(@PathVariable String email){
			
			ResponseEntity<List<BookFlight>> resp=null;
			try {
				List<BookFlight> flightByemail = bookFlights.getByEmail(email);
				resp=ResponseEntity.ok(flightByemail);
			} catch (Exception e) {
				 resp=new ResponseEntity<List<BookFlight>>(HttpStatus.NOT_FOUND);
				 e.printStackTrace();
			}
			return resp;
		}
	
	@DeleteMapping("/getCancelByPnr/{id}")
	public ResponseEntity<String> getCancelByPnr(@PathVariable Integer id){
		
		ResponseEntity<String> resp=null;
		try {
			bookFlights.cancelBookFlight(id);
			resp=ResponseEntity.ok("Fligh Ticket Cancel Succesfully With PNR  " +id);
		} catch (Exception e) {
			 resp=new ResponseEntity<String>("This PNR number not exist ",HttpStatus.NOT_FOUND);
			 e.printStackTrace();
		}
		return resp;
	}

}
