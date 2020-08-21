package com.cts.brownfield.pss.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.brownfield.pss.entity.Fares;
import com.cts.brownfield.pss.entity.Flight;

public interface FlightDao extends JpaRepository<Flight, Long>{

	public Flight findByFlightNumberAndFlightDate(String flightNumber,LocalDate flightDate);
}
