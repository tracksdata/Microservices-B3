package com.cts.brownfield.pss.service;

import com.cts.brownfield.pss.entity.Passenger;

public interface BookingService {

	Passenger book(Passenger passenger, long id, int numberOfPassengers);

}