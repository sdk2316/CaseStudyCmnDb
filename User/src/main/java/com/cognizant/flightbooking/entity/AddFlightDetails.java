package com.cognizant.flightbooking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class AddFlightDetails {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer id;

	private Integer flightNumber;

	private String operatingAirlines;

	private String fromPlace;

	private String toPlace;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;

	private String scheduleDays;

	private Integer businessSeats;

	private Integer nonBusinessSeats;

	private Double cost;
	
	private Boolean block;
	

	public Boolean getBlock() {
		return block;
	}


	public void setBlock(Boolean block) {
		this.block = block;
	}


	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfDeparture;

	public AddFlightDetails(Integer id, Integer flightNumber, String operatingAirlines, String fromPlace,
			String toPlace, Date startDate, Date endDate, String scheduleDays, Integer businessSeats,
			Integer nonBusinessSeats, Double cost, Date dateOfDeparture) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.operatingAirlines = operatingAirlines;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startDate = startDate;
		this.endDate = endDate;
		this.scheduleDays = scheduleDays;
		this.businessSeats = businessSeats;
		this.nonBusinessSeats = nonBusinessSeats;
		this.cost = cost;
		this.dateOfDeparture = dateOfDeparture;
	}
	

	public AddFlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperatingAirlines() {
		return operatingAirlines;
	}

	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getScheduleDays() {
		return scheduleDays;
	}

	public void setScheduleDays(String scheduleDays) {
		this.scheduleDays = scheduleDays;
	}

	public Integer getBusinessSeats() {
		return businessSeats;
	}

	public void setBusinessSeats(Integer businessSeats) {
		this.businessSeats = businessSeats;
	}

	public Integer getNonBusinessSeats() {
		return nonBusinessSeats;
	}

	public void setNonBusinessSeats(Integer nonBusinessSeats) {
		this.nonBusinessSeats = nonBusinessSeats;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}


	@Override
	public String toString() {
		return "FlightDetailsInfo [id=" + id + ", flightNumber=" + flightNumber + ", operatingAirlines="
				+ operatingAirlines + ", fromPlace=" + fromPlace + ", toPlace=" + toPlace + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", scheduleDays=" + scheduleDays + ", businessSeats=" + businessSeats
				+ ", nonBusinessSeats=" + nonBusinessSeats + ", cost=" + cost + ", dateOfDeparture=" + dateOfDeparture
				+ "]";
	}

	

	
}
