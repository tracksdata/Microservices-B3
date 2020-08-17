package com.cts.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RefreshScope
public class TestController {
	
	@Value("${name}")
	private String personName;
	
	@GetMapping
	public String getName() {
		System.out.println(">>>> NAME :::: "+personName);
		return personName;
	}

}
