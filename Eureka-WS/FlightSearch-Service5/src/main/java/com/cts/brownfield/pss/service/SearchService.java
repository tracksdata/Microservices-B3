package com.cts.brownfield.pss.service;

import java.time.LocalDate;
import java.util.List;

import com.cts.brownfield.pss.entity.Flight;

public interface SearchService {
	public Flight findByFlightId(long id);
	List<Flight> search(SearchQuery searchQuery);
	Flight findByFlightNumberAndFlightDate(String flightNumber, LocalDate flightDate);
	void updateInventory(String flightNumber, LocalDate flightDate, int new_inventory);
	}
