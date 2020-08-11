package com.cts.brownfield.pss.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.brownfield.pss.dao.FlightRepository;
import com.cts.brownfield.pss.entity.Flight;
import com.cts.brownfield.pss.entity.Inventory;

@Service
public class SearchFlightServiceImpl implements SearchFlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public double getFare(String flightNumber,LocalDate flightDate) {
		Flight flight=flightRepository.findByFlightNumberAndFlightDate(flightNumber, flightDate);
		return flight.getFares().getFare();
	}
	
	
	public List<Flight> saveAll(List<Flight> flights) {
		return flightRepository.saveAll(flights);
	}
	
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}
	
	public Flight findById(long id) {
		return flightRepository.findById(id).orElse(null);
	}
	
	
	public Flight findById(String flightNumber, LocalDate flightDate) {

		return flightRepository.findByFlightNumberAndFlightDate(flightNumber, flightDate);
	}

	@Override
	public Stream<Flight> search(SearchQuery searchQuery) {

		List<Flight> flights = flightRepository.findByOriginAndDestinationAndFlightDate(searchQuery.getOrigin(),
				searchQuery.getDestination(), searchQuery.getFlightDate());
		// System.out.println("<<<<>>> " + flights);

		Stream<Flight> searchResult = flights.stream()
				.filter(flight -> flight.getInventory().getCount() >= searchQuery.getNumberofPassengers());

		return searchResult;

	}

	@Override
	public void updateInventory(String flightNumber, LocalDate flightDate, LocalTime flightTime, int new_inventory) {

		Flight flight = flightRepository.findByFlightNumberAndFlightDate(flightNumber, flightDate);
		if (flight != null) {
			Inventory inv = flight.getInventory();
			inv.setCount(inv.getCount() - new_inventory);
			flightRepository.save(flight);
		} else { // flight info is not available yet in search schema
			throw new RuntimeException("====> Failed");
		}
	}

	@Override
	public Flight findByFlightNumberAndFlightDate(String flightNumber, LocalDate flightDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight findByFlightNumberAndFlightDateAndFlightTime(String flightNumber, LocalDate flightDate,
			LocalTime flightTime) {

		return flightRepository.findByFlightNumberAndFlightDateAndFlightTime(flightNumber, flightDate, flightTime);
	}

	@Override
	public Flight findByFlightNumberAndFlightDateAndFlightTime(SearchQuery searchQuery) {
		Flight flight = flightRepository.findByFlightNumberAndFlightDateAndFlightTime(searchQuery.getFlightNumber(),
				searchQuery.getFlightDate(), searchQuery.getFlightTime());
		if (flight.getInventory().getCount() < searchQuery.getNumberofPassengers()) {
			return null;
		}
		// TODO Auto-generated method stub
		return flight;
	}

}
