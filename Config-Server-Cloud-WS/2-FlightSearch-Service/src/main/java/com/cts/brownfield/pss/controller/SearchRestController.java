package com.cts.brownfield.pss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.brownfield.pss.entity.Flight;
import com.cts.brownfield.pss.service.SearchQuery;
import com.cts.brownfield.pss.service.SearchService;

@RestController
@RequestMapping("/api/pss")
@CrossOrigin
@RefreshScope
public class SearchRestController {

	@Autowired
	private SearchService searchService;
	
	@PostMapping("/findFlights")
	public List<Flight> searchFlights(@RequestBody SearchQuery searchQuery){
		System.out.println(searchQuery);
		return searchService.search(searchQuery);
	}
	
	@GetMapping("/findFlight/{id}")
	public Flight findFlight(@PathVariable("id")long id) {
		System.out.println("ID: "+id);
		Flight flight=searchService.findByFlightId(id);
		System.out.println("====&&&^%$$  ====>  "+flight);
		return flight;
	}
	
}
