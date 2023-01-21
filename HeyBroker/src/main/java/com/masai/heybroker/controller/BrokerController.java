package com.masai.heybroker.controller;

import com.masai.heybroker.model.Broker;
import com.masai.heybroker.model.Customer;
import com.masai.heybroker.model.Property;
import com.masai.heybroker.service.BrokerService;
import com.masai.heybroker.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/broker")
public class BrokerController {
   
	 @Autowired
	    private BrokerService brokerService;
	    @PostMapping("/register")
	    public ResponseEntity<Broker> registerBrokerHandler(@RequestBody Broker broker){

	     Broker broker1 =  brokerService.registerBroker(broker);

	       return new ResponseEntity<Broker>(broker1, HttpStatus.CREATED);
	    }
	    @PutMapping("/update/{key}")
	    public ResponseEntity<Broker>updateBrokerHandler(@RequestBody Broker broker, @PathVariable String key){

	        Broker broker1 =  brokerService.updateBroker(broker,key);

	          return new ResponseEntity<Broker>(broker1,HttpStatus.OK);
	    }

	@PostMapping("/addproperty/{key}")
	public ResponseEntity<Property> addPropertyHandler(@RequestBody Property property, @PathVariable String key){

		Property  property1=brokerService.registerProperty(property,key);

		return new ResponseEntity<Property>(property1,HttpStatus.CREATED);
	}

	@PutMapping("/editproperty/{key}")
	public ResponseEntity<Property> editPropertyHandler(@RequestBody Property property, @PathVariable String key){

		Property  property1=brokerService.editProperty(property,key);

		return new ResponseEntity<Property>(property1,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteproperty/{id}/{key}")
	public ResponseEntity<Property> deletePropertyHandler(@PathVariable Integer id, @PathVariable String key){

		Property property1=brokerService.removeProperty(id,key);

		return new ResponseEntity<Property>(property1,HttpStatus.OK);
	}

	@GetMapping("/viewallproperty/{id}/{key}")
	public ResponseEntity<List<Property>> viewAllPropertyHandler(@PathVariable Integer id, @PathVariable String key){

		List<Property> property1=brokerService.viewAllProperty(id,key);

		return new ResponseEntity<>(property1,HttpStatus.OK);
	}
	
}
