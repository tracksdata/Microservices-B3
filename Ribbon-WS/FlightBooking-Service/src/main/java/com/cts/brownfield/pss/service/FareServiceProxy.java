package com.cts.brownfield.pss.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.brownfield.pss.entity.Fares;

@FeignClient(name = "fares-service",url = "http://localhost:8081/api/pss")
public interface FareServiceProxy {

	@GetMapping("/getFare/{id}")
	Fares getFare(@PathVariable long id);
	
}
