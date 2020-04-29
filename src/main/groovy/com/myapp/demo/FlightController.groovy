package com.myapp.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import groovy.json.JsonBuilder

@RestController

@RequestMapping('flights')
class FlightController {
	
	
	@Autowired
	FlightService flightService;
	
	
	@GetMapping()
	ResponseEntity findAll() {
		return new ResponseEntity(new JsonBuilder( flightService.findAll()), HttpStatus.OK)
	  
	}
  
	
	
	
	
	
}
