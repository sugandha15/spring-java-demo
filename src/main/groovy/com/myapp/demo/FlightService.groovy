package com.myapp.demo

import javax.annotation.PostConstruct

import org.springframework.stereotype.Component
import groovy.sql.Sql;

@Component
class FlightService {
	
	def sql;

	@PostConstruct	
void initialize() {
	
 sql = Sql.newInstance('jdbc:mysql://localhost:3306/devops',
		'admin', 'admin', 'com.mysql.cj.jdbc.Driver')
}
	
	
	List<Flight> findAllFlights() {
		
		def sql = Sql.newInstance('jdbc:mysql://localhost:3306/devops',
			'admin', 'admin', 'com.mysql.cj.jdbc.Driver')
			   
		def flights=[] as List<Flight>;
		sql.eachRow('SELECT * FROM flights'){flight-> flights.add(new Flight(flight.flightId,
			flight.sourceCity,flight.destinationCity,flight.fare,flight.duration))};
		
		return flights;
		
	}
	
	def insert(Flight flight) {
		def flightsInsert = '''
    INSERT INTO flights 
                VALUES  (?, ?, ?, ?, ?);
'''
	 sql.execute flightsInsert, [flight.getFlightId(),  flight.getSourceCity(), flight.getDestinationCity(),
		flight.getFare(),flight.getDuration()];
	}
	
	def update(Flight flight) {
		
		def flightsUpdate = '''
  UPDATE flights SET fare=? where flightId=?;
'''
		
sql.execute flightsUpdate,[flight.getFare(),flight.getFlightId()]
	}
	
	
	def delete( flightId) {
		
		def flightsDelete = '''
  DELETE FROM flights  where flightId=?;
'''
		
sql.execute flightsDelete,[flightId]
	}
	
	
}
