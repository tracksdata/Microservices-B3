package com.cts.brownfield.pss.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.cts.brownfield.pss.service.SearchService;

@Controller
public class Receiver {
	
	@Autowired
	private SearchService searchService;
	
	@Bean
	Queue queue() {
		return new Queue("InventoryQ", false);
	}
	
	//@RabbitListener(queues = "InventoryQ") // Consumer
    public void processMessage(Map<String,Object> flightObj) {
        System.out.println("^^ ===========> ==== <=========== ^^");
		System.out.println(flightObj);
		System.out.println("vv ===========> ==== <=========== vv");
        searchService.updateInventory((String)flightObj.get("FLIGHT_NUMBER"),(LocalDate)flightObj.get("FLIGHT_DATE"),(int)flightObj.get("NUMBEROFSEATS_BOOKED"));
       //call repository and update the fare for the given flight
    }	
	
	

	
}
