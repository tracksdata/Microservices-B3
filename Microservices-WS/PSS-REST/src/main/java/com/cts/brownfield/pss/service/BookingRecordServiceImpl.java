package com.cts.brownfield.pss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.brownfield.pss.dao.BookingRecordDao;
import com.cts.brownfield.pss.entity.BookingRecord;

@Service
public class BookingRecordServiceImpl implements BookingRecordService{

	@Autowired
	private BookingRecordDao bookinRecordDao;
	
	@Override
	public BookingRecord findByBookingId(long bookingId) {
		return bookinRecordDao.findByBookingId(bookingId);
	}

}
