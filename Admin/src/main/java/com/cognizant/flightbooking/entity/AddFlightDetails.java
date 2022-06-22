package com.cognizant.flightbooking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"flightNumber"})})
public class AddFlightDetails {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Column(name = "flightNumber")
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

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfDeparture;
	
	private boolean block;
	

	public boolean isBlock() {
		return block;
	}



	public void setBlock(boolean block) {
		this.block = block;
	}



	public AddFlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public AddFlightDetails(Integer id, String operatingAirlines, String fromPlace,
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
	

	public String getScheduleDays() {
		return scheduleDays;
	}



	public void setScheduleDays(String scheduleDays) {
		this.scheduleDays = scheduleDays;
	}



	@Override
	public String toString() {
		return "AddFlightDetails [id=" + id + ", flightNumber=" + flightNumber + ", operatingAirlines="
				+ operatingAirlines + ", fromPlace=" + fromPlace + ", toPlace=" + toPlace + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", scheduleDays=" + scheduleDays + ", businessSeats=" + businessSeats
				+ ", nonBusinessSeats=" + nonBusinessSeats + ", cost=" + cost + ", dateOfDeparture=" + dateOfDeparture
				+ "]";
	}



}
