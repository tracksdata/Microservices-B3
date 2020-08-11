package com.cts.brownfield.pss.service;

import java.time.LocalDate;
import java.time.LocalTime;

public class SearchQuery {

	private String flightNumber;
	private String origin;
	private String destination;
	private LocalDate flightDate;

	private LocalTime flightTime;

	private int numberofPassengers;

	public SearchQuery() {
		// TODO Auto-generated constructor stub
	}

	public SearchQuery(String origin, String destination, LocalDate localDate, int numberofPassengers) {

		this.origin = origin;
		this.destination = destination;
		this.flightDate = localDate;
		this.numberofPassengers = numberofPassengers;
	}

	public SearchQuery(String flightNumber, String origin, String destination, LocalDate flightDate,
			LocalTime flightTime) {
		super();
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
	}

	public SearchQuery(String flightNumber, LocalDate flightDate, LocalTime flightTime, int numberofPassengers) {
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.numberofPassengers = numberofPassengers;

	}
	
	public SearchQuery(String flightNumber, LocalDate flightDate, LocalTime flightTime) {
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		

	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getNumberofPassengers() {
		return numberofPassengers;
	}

	public void setNumberofPassengers(int numberofPassengers) {
		this.numberofPassengers = numberofPassengers;
	}

	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	@Override
	public String toString() {
		return "SearchQuery [origin=" + origin + ", destination=" + destination + ", flightDate=" + flightDate + "]";
	}

}
