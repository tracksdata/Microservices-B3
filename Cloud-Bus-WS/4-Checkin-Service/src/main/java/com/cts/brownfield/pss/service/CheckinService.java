package com.cts.brownfield.pss.service;


import com.cts.brownfield.pss.entity.CheckIn;

public interface CheckinService {

	

	CheckIn checkIn(long bookingId);

	CheckIn getCheckInInfo(long bookingId);

}