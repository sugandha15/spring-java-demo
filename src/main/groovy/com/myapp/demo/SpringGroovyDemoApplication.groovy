package com.myapp.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

@SpringBootApplication
class SpringGroovyDemoApplication implements CommandLineRunner {
	
	// Dependency Injection
	
	
	@Autowired
	FlightService flightService ;
	
	@Bean public ObjectMapper objectMapper() {
		return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);}
	

	static void main(String[] args) {
		SpringApplication.run(SpringGroovyDemoApplication, args)
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//flightService.update(new Flight(122,'Mangalore','Delhi',4989.45,3.2))
		
		flightService.delete(122);
		println flightService.findAllFlights();
		
		
		
	}

}
