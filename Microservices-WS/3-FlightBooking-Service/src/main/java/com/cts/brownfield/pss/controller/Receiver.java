package com.cts.brownfield.pss.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cts.brownfield.pss.service.BookingService;

@Controller
public class Receiver {

	@Autowired
	private BookingService bookingSerice;

	@RabbitListener(queues = "CheckINQ")
	public void processMessage(long bookingID) {
		bookingSerice.updateStatus("CHECKED-IN", bookingID);
	}

}
