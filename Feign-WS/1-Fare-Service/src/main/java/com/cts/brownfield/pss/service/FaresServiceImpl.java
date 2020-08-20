package com.cts.brownfield.pss.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.brownfield.pss.dao.FlightDao;
import com.cts.brownfield.pss.entity.Fares;
import com.cts.brownfield.pss.entity.Flight;

@Service
public class FaresServiceImpl implements FaresService {
	@Autowired
	private FlightDao flightDao;
	
	@Override
	public Fares getFare(String flightNumber,LocalDate flightDate) {
		return flightDao.findByFlightNumberAndFlightDate(flightNumber, flightDate).getFares();
	}
	
	@Override
	public Fares getFareByFlightId(long id) {
		Flight flight=flightDao.findById(id).orElse(null);
		if(flight!=null) {
			return flight.getFares();
		}
		return null;
	}

}
