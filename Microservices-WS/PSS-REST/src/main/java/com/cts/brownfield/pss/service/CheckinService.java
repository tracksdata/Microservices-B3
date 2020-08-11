package com.cts.brownfield.pss.service;

import com.cts.brownfield.pss.entity.CheckIn;

public interface CheckinService {
	
	CheckIn findByBookingId(long bookingId);

	boolean existsByBookingId(long bookingId);

	CheckIn save(CheckIn checkIn);

}
