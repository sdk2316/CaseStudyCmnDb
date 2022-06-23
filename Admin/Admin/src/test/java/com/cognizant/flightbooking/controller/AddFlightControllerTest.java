package com.cognizant.flightbooking.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cognizant.flightbooking.entity.AddFlightDetails;
import com.cognizant.flightbooking.service.IAddFlightService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class AddFlightControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IAddFlightService addFlightService;

	@Autowired
	private ObjectMapper objectMapper;

	AddFlightDetails addFlightDetails;

	@Test
	@DisplayName("Controller addFlight")
	public void addFlight() throws JsonProcessingException, Exception {

		// given
		addFlightDetails = new AddFlightDetails(334455, "India Airway", "Mum", "Pune",
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"), "All Days", 30, 40, 555.0,
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));

		BDDMockito.given(addFlightService.saveFlight(ArgumentMatchers.any(AddFlightDetails.class)))
				.willAnswer((invocation) -> invocation.getArgument(0));

		// when

		ResultActions response = mockMvc
				.perform(MockMvcRequestBuilders.post("/addFlight").contentType(MediaType.APPLICATION_JSON)
						.contentType(objectMapper.writeValueAsString(addFlightDetails)));

		// then
		response.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isCreated()).andExpect(
				MockMvcResultMatchers.jsonPath("$.fromPlace", CoreMatchers.is(addFlightDetails.getFromPlace())));
	}

	@Test
	@DisplayName("Controller getAllFlight")
	public void getAllFlight() throws JsonProcessingException, Exception {

		// given
		List<AddFlightDetails> listofflight = new ArrayList<>();
		addFlightDetails = new AddFlightDetails(334455, "India Airway", "Mum", "Pune",
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"), "All Days", 30, 40, 555.0,
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));

		AddFlightDetails addFlightDetails2 = new AddFlightDetails(334455, "India Asia Airway", "Mum", "Pune",
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"), "All Days", 30, 40, 555.0,
				new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));

		listofflight.add(addFlightDetails);
		listofflight.add(addFlightDetails2);

		BDDMockito.given(addFlightService.getAllFlight()).willReturn(listofflight);

		// when

		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/allFlights"));

		// then
		response.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(listofflight.size())));
	}
	
	

}
