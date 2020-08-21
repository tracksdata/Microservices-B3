package com.cts.brownfield.pss.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${originairports.shutdown}")
	private String originAirportShutdownList;

	
	@PostMapping("/findFlights")
	public List<Flight> searchFlights(@RequestBody SearchQuery searchQuery){
		System.out.println(">>>>>>>>>>>>>>> Search-Service1 :::::: Shut down airports ::::: "+originAirportShutdownList);
		System.out.println(searchQuery);
        if(Arrays.asList(originAirportShutdownList.split(","))	.contains(searchQuery.getOrigin())) {
            System.out.println("The origin airport is in shutdown state");
             return new ArrayList<Flight>();
         }

		return searchService.search(searchQuery);
	}
	
	@GetMapping("/findFlight/{id}")
	public Flight findFlight(@PathVariable("id")long id) {
		System.out.println(">>>>>>>>>>>>>>> Search-Service1 :::::: Shut down airports ::::: "+originAirportShutdownList);

		System.out.println("ID: "+id);
		Flight flight=searchService.findByFlightId(id);
		System.out.println("====&&&^%$$  ====>  "+flight);
		return flight;
	}
	
}
