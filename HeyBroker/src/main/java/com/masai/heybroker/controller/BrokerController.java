package com.masai.heybroker.controller;

import com.masai.heybroker.model.Broker;
import com.masai.heybroker.service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerController {
    @Autowired
    private BrokerService bService;
    @PostMapping("/register")
    public ResponseEntity<Broker> registerBrokerHandler(@RequestBody Broker broker){
        Broker broker1 =  bService.registerBroker(broker);

        return new ResponseEntity<Broker>(broker1, HttpStatus.CREATED);
    }
}
