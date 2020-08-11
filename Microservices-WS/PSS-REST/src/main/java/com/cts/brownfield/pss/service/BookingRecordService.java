package com.cts.brownfield.pss.service;

import com.cts.brownfield.pss.entity.BookingRecord;

public interface BookingRecordService {
	BookingRecord findByBookingId(long bookingId);


}
