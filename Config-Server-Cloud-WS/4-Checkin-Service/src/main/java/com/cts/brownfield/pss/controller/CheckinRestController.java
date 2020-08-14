package com.cts.brownfield.pss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.brownfield.pss.entity.CheckIn;
import com.cts.brownfield.pss.service.CheckinService;

@RestController
@CrossOrigin
@RequestMapping("/api/pss")
public class CheckinRestController {
	
	@Autowired
	private CheckinService checkinService;
	
	@PostMapping("/checkIn/{bookingId}")
	public CheckIn checkIn(@PathVariable("bookingId")long bookingId) {
		return  checkinService.checkIn(bookingId);
	}
	
	@GetMapping("/checkIn/{bookingId}")
	public CheckIn getCheckinInfo(@PathVariable("bookingId")long bookingId) {
		return checkinService.getCheckInInfo(bookingId);
	}

}
