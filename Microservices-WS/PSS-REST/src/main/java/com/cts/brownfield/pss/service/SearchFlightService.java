package com.cts.brownfield.pss.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import com.cts.brownfield.pss.entity.Flight;

public interface SearchFlightService {
	public double getFare(String flightNumber,LocalDate flightDate);
	
	public List<Flight> saveAll(List<Flight> flights);
	
	public List<Flight> findAll();
	
	public Flight findById(long id);

	Stream<Flight> search(SearchQuery searchQuery);

	void updateInventory(String flightNumber, LocalDate flightDate, LocalTime flightTime, int new_inventory);

	Flight findByFlightNumberAndFlightDate(String flightNumber, LocalDate flightDate);

	Flight findByFlightNumberAndFlightDateAndFlightTime(String flightNumber, LocalDate flightDate,
			LocalTime flightTime);

	Flight findByFlightNumberAndFlightDateAndFlightTime(SearchQuery searchQuery);

}