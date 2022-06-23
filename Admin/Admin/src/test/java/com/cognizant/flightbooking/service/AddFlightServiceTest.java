package com.cognizant.flightbooking.service;

import static org.mockito.BDDMockito.given;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.flightbooking.entity.AddFlightDetails;
import com.cognizant.flightbooking.exception.FlightNumberAlreadyExistException;
import com.cognizant.flightbooking.repossitory.AddFlightRepository;
import com.sun.tools.javac.util.List;

@ExtendWith(MockitoExtension.class)
public class AddFlightServiceTest {
	@Mock
	private AddFlightRepository addFlightRepository;

	@InjectMocks
	private AddFlightServiceImpl addFlightService;
	private AddFlightDetails addFlightDetails;

	@BeforeEach
	public void setup() throws ParseException {
		addFlightDetails = new AddFlightDetails(32363, "India Airway", "Mum", "Pune",
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"), "All Days", 30, 40, 555.0,
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));

	}

	@DisplayName("saveflight from service layer")
	@Test
	public void saveFlight()  {

		given(addFlightRepository.findByFlightNumber(addFlightDetails.getFlightNumber()))
				.willReturn(Optional.empty());
		
		given(addFlightRepository.save(addFlightDetails)).willReturn(addFlightDetails);

		
		// when
		Integer saveFlight = addFlightService.saveFlight(addFlightDetails);
		// then
		Assertions.assertThat(saveFlight).isNotNull();
	}

	@DisplayName("throw exception")
	@Test
	public void saveFlightException() throws ParseException {

		given(addFlightRepository.findByFlightNumber(addFlightDetails.getFlightNumber()))
				.willReturn(Optional.of(addFlightDetails));

		// given(addFlightRepository.save(addFlightDetails)).willReturn(addFlightDetails);

		System.out.println(addFlightRepository);
		System.out.println(addFlightService);

		// when
		org.junit.jupiter.api.Assertions.assertThrows(FlightNumberAlreadyExistException.class, () -> {
			addFlightService.saveFlight(addFlightDetails);
		});
		// then
		// verify(addFlightRepository,never()).save( any(AddFlightDetails.class));
	}

	@DisplayName("getAllFlight")
	@Test
	public void getAllFlight() throws ParseException {
		AddFlightDetails addFlightDetails2 = new AddFlightDetails(3233, "India Airway", "Mum", "Pune",
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"), "All Days", 30, 40, 555.0,
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));

		given(addFlightRepository.findAll()).willReturn(List.of(addFlightDetails, addFlightDetails2));

		// when
		java.util.List<AddFlightDetails> allFlightList = addFlightService.getAllFlight();
		// then

		Assertions.assertThat(allFlightList).isNotNull();
		Assertions.assertThat(allFlightList.size()).isEqualTo(2);
	}

	@DisplayName("getAllFlight negative scenario with empty list")
	@Test
	public void getAllFlightNegativeScenario() throws ParseException {
		AddFlightDetails addFlightDetails2 = new AddFlightDetails(3233, "India Airway", "Mum", "Pune",
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"), "All Days", 30, 40, 555.0,
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));

		given(addFlightRepository.findAll()).willReturn(Collections.emptyList());

		// when
		java.util.List<AddFlightDetails> allFlightList = addFlightService.getAllFlight();
		// then

		Assertions.assertThat(allFlightList).isEmpty();
		Assertions.assertThat(allFlightList.size()).isEqualTo(0);
	}

	@DisplayName("getFlightByName ")
	@Test
	public void getFlightByName() throws ParseException {

		given(addFlightRepository.findByOperatingAirlines("India Airway")).willReturn(Optional.of(addFlightDetails));

		// when
		AddFlightDetails flight = addFlightService.getFlight(addFlightDetails.getOperatingAirlines());
		// then

		Assertions.assertThat(flight).isNotNull();

	}

}
