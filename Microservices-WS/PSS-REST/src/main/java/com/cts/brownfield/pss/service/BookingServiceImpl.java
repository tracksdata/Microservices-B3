package com.cts.brownfield.pss.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.brownfield.pss.dao.FlightRepository;
import com.cts.brownfield.pss.dao.PassengerDao;
import com.cts.brownfield.pss.entity.BookingRecord;
import com.cts.brownfield.pss.entity.Flight;
import com.cts.brownfield.pss.entity.Inventory;
import com.cts.brownfield.pss.entity.Passenger;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private SearchFlightService searchFlightService;
	@Autowired
	private PassengerDao passengerDao;

	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Passenger book(Passenger passenger, long id, int numberOfPassengers) {

		Flight flight = searchFlightService.findById(id);
		BookingRecord bookingRecord = null;

		if (flight != null) {
			bookingRecord = new BookingRecord(flight.getFlightNumber(), flight.getOrigin(), flight.getDestination(),
					flight.getFlightDate(), flight.getFlightTime(), LocalDateTime.now(), flight.getFares().getFare(),
					"Confirmed");
			// bookingRecord.setPassenger(passenger);
			bookingRecord.setFare(flight.getFares().getFare() * numberOfPassengers);
			passenger.setBookingRecord(bookingRecord);
			if (passenger.getCoPassengers().size() == numberOfPassengers - 1) {
				passengerDao.save(passenger);
				// bookingRecordDao.save(bookingRecord);

				Inventory inv = flight.getInventory();
				inv.setCount(inv.getCount() - numberOfPassengers);
				flightRepository.save(flight);
			}
		}

		return passenger;
	}


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

	public boolean book(Flight flight) {

		// BookingRecord bookingRecord = new BookingRecord(flight.getFlightNumber(),
		// flight.getOrigin(),
		// flight.getDestination(), flight.getFlightDate(), flight.getFlightTime(),
		// LocalDateTime.now(),
		// flight.getFares().getFare(), "Confirmed");

		// Passenger p1 = new Passenger("Praveen", "Reddy", "Male", 1212121212,
		// "praveen@abc.com", bookingRecord);

		return true;

	}

}
