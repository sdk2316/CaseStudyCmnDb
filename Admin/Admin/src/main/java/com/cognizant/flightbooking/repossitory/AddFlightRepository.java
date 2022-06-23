package com.cognizant.flightbooking.repossitory;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.flightbooking.entity.AddFlightDetails;


@Transactional
@Repository
public interface AddFlightRepository extends JpaRepository<AddFlightDetails, Integer> {
	// @Query(" from AddFlight where operatingAirlines=:operatingAirlines")
	Optional<AddFlightDetails> findByOperatingAirlines(String flightName);

	Optional<AddFlightDetails> findByFlightNumber(Integer flightNumber);
	
	// @Query(" select from AddFlightDetails where fromPlace=:fromPlace and toPlace=:toPlace")
	List<Object> findByFromPlaceAndToPlace( String fromPlace,String toPlace);
	
	@Query("select flightNumber,operatingAirlines,fromPlace,toPlace,startDate,endDate,cost,dateOfDeparture from AddFlightDetails where fromPlace=:fromPlace and toPlace=:toPlace")
	List<Object> findByFromAndTo( String fromPlace,String toPlace);

	@Query("FROM AddFlightDetails WHERE fromPlace =:fromPlace and toPlace =:toPlace and cast(startDate as date) =:startDate")
	List<AddFlightDetails> searchFlight(String fromPlace, String toPlace,  Date startDate);

	 
	@Transactional
	@Modifying
	@Query("UPDATE AddFlightDetails SET block = :block WHERE flightNumber = :flightNumber")
	Integer updateAirline(Integer flightNumber, boolean block);

	
}
