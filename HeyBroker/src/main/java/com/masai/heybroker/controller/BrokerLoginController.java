package com.masai.heybroker.controller;

import com.masai.heybroker.model.AdminLoginDTO;
import com.masai.heybroker.model.BrokerLoginDTO;
import com.masai.heybroker.service.AdminLoginService;
import com.masai.heybroker.service.BrokerLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/brokerlogin")
public class BrokerLoginController {
    @Autowired
    private BrokerLoginService brokerLoginService;

    @PostMapping("/login")
    public ResponseEntity<String> brokerLoginHandler(@Valid @RequestBody BrokerLoginDTO brokerLoginDTO){

       String key= brokerLoginService.logIntoAccount(brokerLoginDTO);
        return new ResponseEntity<String>(key, HttpStatus.ACCEPTED);
    }

    @GetMapping("/logout/{key}")
    public ResponseEntity<String> brokerLogoutHandler(@PathVariable String key){

        String key1 = brokerLoginService.logOutFromAccount(key);
        return new ResponseEntity<String>(key1, HttpStatus.ACCEPTED);
    }
}
