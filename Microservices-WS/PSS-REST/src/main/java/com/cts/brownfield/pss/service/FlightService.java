package com.cts.brownfield.pss.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.cts.brownfield.pss.entity.Flight;

public interface FlightService {
	
	List<Flight> findByOriginAndDestinationAndFlightDate(String origin, String destination, LocalDate flightDate);

	Flight findByFlightNumberAndFlightDate(String flightNumber, LocalDate flightDate);

	Flight findByFlightNumberAndFlightDateAndFlightTime(String flightNumber, LocalDate flightDate,
			LocalTime flightTime);
	
	
	Flight findByFlightNumber(String flightNumber);

}
