package com.cts.brownfield.pss.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.brownfield.pss.entity.BookingRecord;

public interface BookingRecordDao extends JpaRepository<BookingRecord, Long> {
	
	
	BookingRecord findByBookingId(long bookingId);

}
