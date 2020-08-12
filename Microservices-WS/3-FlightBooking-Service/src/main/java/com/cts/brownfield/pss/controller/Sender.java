package com.cts.brownfield.pss.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Sender {
	
	@Autowired
	private RabbitMessagingTemplate template;
	
	@Bean
	Queue queue() {
		return new Queue("InventoryQ", false);
	}
	@Bean
	Queue queue1() {
		return new Queue("CheckinQ", false);
	}
	
	/*
	@Bean
	    public Jackson2JsonMessageConverter converter() {
	        return new Jackson2JsonMessageConverter();
	    }
	   */
	
	public void send(Object map){
		template.convertAndSend("InventoryQ", map);
	}

}
