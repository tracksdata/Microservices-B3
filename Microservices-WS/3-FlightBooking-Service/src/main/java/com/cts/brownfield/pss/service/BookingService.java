package com.cts.brownfield.pss.service;

import com.cts.brownfield.pss.entity.BookingRecord;
import com.cts.brownfield.pss.entity.Passenger;

public interface BookingService {

	Passenger bookFlight(Passenger passenger, long id, int numberOfPassengers);
	public void updateStatus(String status, long bookingId);
	public BookingRecord getBookingInfo(long bookingId);

}