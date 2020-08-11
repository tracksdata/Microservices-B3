package com.cts.brownfield.pss.service;

import com.cts.brownfield.pss.entity.BookingRecord;
import com.cts.brownfield.pss.entity.Passenger;

public interface PassengerService {
	Passenger findByBookingRecord(BookingRecord bookingRecord);

}
