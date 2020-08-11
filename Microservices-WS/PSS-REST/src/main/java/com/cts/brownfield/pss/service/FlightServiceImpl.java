package com.cts.brownfield.pss.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.brownfield.pss.dao.FlightRepository;
import com.cts.brownfield.pss.entity.Flight;
@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightRepository flightDao;
	
	@Override
	public List<Flight> findByOriginAndDestinationAndFlightDate(String origin, String destination,
			LocalDate flightDate) {
		// TODO Auto-generated method stub
		return flightDao.findByOriginAndDestinationAndFlightDate(origin, destination, flightDate);
	}

	@Override
	public Flight findByFlightNumberAndFlightDate(String flightNumber, LocalDate flightDate) {
		// TODO Auto-generated method stub
		return flightDao.findByFlightNumberAndFlightDate(flightNumber, flightDate);
	}

	@Override
	public Flight findByFlightNumberAndFlightDateAndFlightTime(String flightNumber, LocalDate flightDate,
			LocalTime flightTime) {
		// TODO Auto-generated method stub
		return flightDao.findByFlightNumberAndFlightDateAndFlightTime(flightNumber, flightDate, flightTime);
	}

	@Override
	public Flight findByFlightNumber(String flightNumber) {
		// TODO Auto-generated method stub
		return flightDao.findByFlightNumber(flightNumber);
	}
	
	

}
