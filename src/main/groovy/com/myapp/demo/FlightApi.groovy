package com.myapp.demo
 import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.AssertTrue.List
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
@RestController
@RequestMapping("flight")
class FlightApi {
	
	@Autowired
	
	FlightService flightService;
	
	@GetMapping   // to map get type of request
	
	List findAll() {
		
		return flightService.findAllFlights();
	}
	
	
	// expressjs app.post('',(req,res)=>req.body)
	@PostMapping
	ResponseEntity save(@RequestBody flight) {
		flightService.insert(flight)
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	//expressjs app.post('',(req,res)=>req.body)
	
	@PutMapping
	
	ResponseEntity update(@RequestBody flight) {
		flightService.insert(flight);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	// http://localhost:8080/flight/321
	// expressjs app.delete('',(req,res)=>req.params.id )
	
	@DeleteMapping("/{id}")
	ResponseEntity delete(@PathVariable("id")flightid) {
	
	flightService.delete(flightid);
	return new ResponseEntity(HttpStatus.OK);
	}
}
