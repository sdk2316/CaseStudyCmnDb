package com.cognizant.flightbooking.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cognizant.flightbooking.entity.AddFlightDetails;
import com.cognizant.flightbooking.repossitory.AddFlightRepository;

@DataJpaTest
public class AddFlightRepositoryTest {
	
	@Autowired 
	private AddFlightRepository addFlightRepository;
	AddFlightDetails addFlightDetails;
	@Test
	@DisplayName("saveFlight")
	public void saveFlight() throws ParseException {
		
		//AddFlightDetails(09890,"India Airway","Mum","Pune",2022-05-30,2022-06-02,"All Days",30,40,555.0,2022-05-30);
		// given
		addFlightDetails=new AddFlightDetails();
		//addFlightDetails.setFlightNumber(Integer.valueOf(09878));
		addFlightDetails.setFlightNumber(23456);
		addFlightDetails.setOperatingAirlines("air india");
		addFlightDetails.setFromPlace("Pune");
		addFlightDetails.setToPlace("Eng");
		addFlightDetails.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));
		addFlightDetails.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"));
		addFlightDetails.setScheduleDays("AllDays");
		addFlightDetails.setBusinessSeats(23);
		addFlightDetails.setNonBusinessSeats(24);
		addFlightDetails.setCost(3344.99);
		addFlightDetails.setDateOfDeparture(new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));
		
		
		
		
		// when
		AddFlightDetails saveflight = addFlightRepository.save(addFlightDetails);
		
		// then -verifying the output
		Assertions.assertThat(saveflight).isNotNull();
		Assertions.assertThat(saveflight.getId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("AllFlights")
	public void getAllFlight() throws ParseException {
	 addFlightDetails=new AddFlightDetails(3233,"India Airway","Mum","Pune",new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"),"All Days",30,40,555.0,new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));
	
		AddFlightDetails addFlightDetails2=new AddFlightDetails(34433,"Dev Airway","Mum","Pune",new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"),"All Days",30,40,555.0,new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));

		AddFlightDetails addFlightDetails3=new AddFlightDetails(35533,"Dell Airway","Mum","Pune",new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"),"All Days",30,40,555.0,new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));
		
		addFlightRepository.save(addFlightDetails);
		addFlightRepository.save(addFlightDetails2);
		addFlightRepository.save(addFlightDetails3);
		
		List<AddFlightDetails> flightList = addFlightRepository.findAll();
		Assertions.assertThat(flightList).isNotNull();
		Assertions.assertThat(flightList.size()).isEqualTo(3);

	}
	
	@Test
	@DisplayName("getByFlightNumber")
	public void getByFlightNumber() throws ParseException {
		AddFlightDetails addFlightDetails=new AddFlightDetails(3233,"India Airway","Mum","Pune",new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"),"All Days",30,40,555.0,new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));
	
		AddFlightDetails addFlightDetails2=new AddFlightDetails(34433,"Dev Airway","Mum","Pune",new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"),"All Days",30,40,555.0,new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));

		AddFlightDetails addFlightDetails3=new AddFlightDetails(35533,"Dell Airway","Mum","Pune",new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"),"All Days",30,40,555.0,new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));
		
		addFlightRepository.save(addFlightDetails);
		addFlightRepository.save(addFlightDetails2);
		addFlightRepository.save(addFlightDetails3);
		
		 addFlightRepository.findByFlightNumber(addFlightDetails.getFlightNumber()).get();
		Assertions.assertThat(addFlightDetails).isNotNull();
		

	}
	
	
	@Test
	@DisplayName("getByFlightName")
	public void getByFlightName() throws ParseException {
		AddFlightDetails addFlightDetails=new AddFlightDetails(3233,"India Airway","Mum","Pune",new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"),"All Days",30,40,555.0,new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));
	
		AddFlightDetails addFlightDetails2=new AddFlightDetails(34433,"Dev Airway","Mum","Pune",new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"),"All Days",30,40,555.0,new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));

		AddFlightDetails addFlightDetails3=new AddFlightDetails(35533,"Dell Airway","Mum","Pune",new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"),"All Days",30,40,555.0,new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));
		
		addFlightRepository.save(addFlightDetails);
		addFlightRepository.save(addFlightDetails2);
		addFlightRepository.save(addFlightDetails3);
		
		// addFlightRepository.findByFlightNumber(addFlightDetails.getFlightNumber()).get();
		 addFlightRepository.findByOperatingAirlines(addFlightDetails.getOperatingAirlines()).get();
		 
		Assertions.assertThat(addFlightDetails).isNotNull();
		

	}
	
	
	@Test
	@DisplayName("deleteFlightByNumber")
	public void deleteFlightByNumber() throws ParseException {
		 addFlightDetails=new AddFlightDetails(3233,"India Airway","Mum","Pune",new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"),"All Days",30,40,555.0,new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));
	
		
		addFlightRepository.save(addFlightDetails);
		
		addFlightRepository.delete(addFlightDetails);
		
		 Optional<AddFlightDetails> existFlightNumber = addFlightRepository.findByFlightNumber(addFlightDetails.getFlightNumber());
		
		 
		Assertions.assertThat(existFlightNumber).isEmpty();
		

	}


	@Test
	@DisplayName("updateFlightByNumber")
	public void updateFlightByNumber() throws ParseException {
		 addFlightDetails=new AddFlightDetails(3233,"India Airway","Mum","Pune",new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"),new SimpleDateFormat("yyyy-MM-dd").parse("2022-06-02"),"All Days",30,40,555.0,new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-30"));
	
		
		addFlightRepository.save(addFlightDetails);
		
		// addFlightRepository.findByFlightNumber(addFlightDetails.getFlightNumber()).get();
		 AddFlightDetails existFlightNumber = addFlightRepository.findByFlightNumber(addFlightDetails.getFlightNumber()).get();
		 existFlightNumber.setOperatingAirlines("Us Airway");
		 
		 AddFlightDetails updateFlight = addFlightRepository.save(existFlightNumber);
			
		 
		Assertions.assertThat(updateFlight.getOperatingAirlines()).isEqualTo("Us Airway");
		

	}

}
