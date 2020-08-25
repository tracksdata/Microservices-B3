package com.cts.brownfield.pss.service;

import java.time.LocalDate;

import com.cts.brownfield.pss.entity.Fares;

public interface FaresService {

	Fares getFare(String flightNumber, LocalDate flightDate);
	public Fares getFareByFlightId(long id);

}