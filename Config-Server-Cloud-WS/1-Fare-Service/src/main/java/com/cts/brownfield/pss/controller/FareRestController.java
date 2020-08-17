package com.cts.brownfield.pss.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.brownfield.pss.entity.Fares;
import com.cts.brownfield.pss.service.FaresService;

@RestController
@CrossOrigin
@RequestMapping("/api/pss")
@RefreshScope
public class FareRestController {
	@Autowired
	private FaresService faresService;

	@GetMapping("/getFare/{flightNumber}/{flightDate}")
	public Fares getFare(@PathVariable("flightNumber") String flightNumber,
			@PathVariable("flightDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate flightDate) {
		
		return faresService.getFare(flightNumber, flightDate);
	}
	
	@GetMapping("/getFare/{id}")
	public Fares getFareByFlightId(@PathVariable("id") long id) {
		return faresService.getFareByFlightId(id);
	}


}
