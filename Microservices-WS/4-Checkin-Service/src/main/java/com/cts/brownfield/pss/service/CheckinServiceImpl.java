package com.cts.brownfield.pss.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.brownfield.pss.controller.Sender;
import com.cts.brownfield.pss.dao.CheckInDao;
import com.cts.brownfield.pss.entity.BookingRecord;
import com.cts.brownfield.pss.entity.CheckIn;
import com.cts.brownfield.pss.entity.Passenger;

@Service
public class CheckinServiceImpl implements CheckinService {
	@Autowired
	private CheckInDao checkinDao;
	@Autowired
	private PassengerService passengerService;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private Sender sender;
	private static final String bookingURL = "http://localhost:8083/api/pss";

	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public CheckIn checkIn(long bookingId) {

		
		CheckIn checkinObj = null;

		// call booking-service to get know whether booking was done or not
		BookingRecord bookingRecord = restTemplate.getForObject(bookingURL + "/book/" + bookingId, BookingRecord.class);

		if (bookingRecord != null) { // booking existed
			Passenger pass = passengerService.findByBookingRecord(bookingRecord);
			if (pass != null) {
				checkinObj = new CheckIn();
				checkinObj.setBookingId(bookingId);
				checkinObj.setCheckinTime(LocalDateTime.now());
				checkinObj.setFlightNumber(pass.getBookingRecord().getFlightNumber());
				checkinObj.setPassenger(pass);
				checkinObj.setSeatNumber("F4");

				checkinDao.save(checkinObj);
				// Send bookingId to Booking-Service Microservice via RabbitMQ to update the
				// status to CHECKED_IN
				sender.send(bookingId);

			}
			return checkinObj;

		}

		return null; // If bookingId not found
	}

	@Override
	public CheckIn getCheckInInfo(long bookingId) {
		CheckIn checkIn = checkinDao.findByBookingId(bookingId);
		if (checkIn == null) {
			return null; // Not yet checked in for this bookingId
		}
		return checkinDao.findByBookingId(bookingId);
	}

}
