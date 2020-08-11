package com.cts.brownfield.pss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.brownfield.pss.dao.CheckInDao;
import com.cts.brownfield.pss.entity.CheckIn;
@Service
public class CheckinServiceImpl implements CheckinService{
	
	@Autowired
	private CheckInDao checkinDao;

	@Override
	public CheckIn findByBookingId(long bookingId) {
		// TODO Auto-generated method stub
		return checkinDao.findByBookingId(bookingId);
	}

	@Override
	public boolean existsByBookingId(long bookingId) {
		// TODO Auto-generated method stub
		return checkinDao.existsByBookingId(bookingId);
	}

	@Override
	public CheckIn save(CheckIn checkIn) {
		// TODO Auto-generated method stub
		return checkinDao.save(checkIn);
	}

}
