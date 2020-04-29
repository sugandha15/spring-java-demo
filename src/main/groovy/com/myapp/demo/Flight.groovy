package com.myapp.demo

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@EqualsAndHashCode
@TupleConstructor(includes=["flightId","sourceCity","destinationCity","fare","duration"])
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Flight implements Serializable {
	
	@JsonProperty
	int flightId;
	
	@JsonProperty
	String sourceCity,destinationCity;
	
	@JsonProperty
	double fare,duration;
	
	
	
	
}
