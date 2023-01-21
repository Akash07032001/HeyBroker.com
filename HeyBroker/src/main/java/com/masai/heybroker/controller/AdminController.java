package com.masai.heybroker.controller;

import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.Broker;
import com.masai.heybroker.model.Customer;
import com.masai.heybroker.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdminHandler(@Valid @RequestBody Admin admin){

       Admin admin1 =  adminService.createAdmin(admin);

       return new ResponseEntity<Admin>(admin1, HttpStatus.CREATED);
    }
    @PutMapping("/update/{key}")
    public ResponseEntity<Admin>updateAdminHandler(@Valid @RequestBody Admin admin, @PathVariable String key){

          Admin admin1 =  adminService.updateAdmin(admin,key);

          return new ResponseEntity<Admin>(admin1,HttpStatus.OK);
    }

    @DeleteMapping("/removecustomer/{key}/{cId}")
    public ResponseEntity<Customer> removeCustomerHandler(@PathVariable String key , @PathVariable Integer cId){

           Customer deletedCustomer =  adminService.removeCustomer(key,cId);
            return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);

    }
    @DeleteMapping("/removebroker/{key}/{bId}")
    public ResponseEntity<Broker> removeBrokerHandler(@PathVariable String key, @PathVariable Integer bId){

        Broker broker = adminService.removeBroker(key,bId);

        return new ResponseEntity<>(broker, HttpStatus.OK);

    }

    @GetMapping("getallcustomer/{key}")
    public ResponseEntity<List<Customer>> getAllCustomerHandler(@PathVariable String key){

        List<Customer> customers = adminService.getAllCustomer(key);

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("getallbroker/{key}")
    public ResponseEntity<List<Broker>> getAllBrokerHandler(@PathVariable String key){

        List<Broker> brokers = adminService.getAllBroker(key);

        return new ResponseEntity<>(brokers, HttpStatus.OK);
    }


    @GetMapping("getcustomer/{key}/{cId}")
    public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable String key , @PathVariable Integer cId){

        Customer customer = adminService.getCustomerById(key,cId);

        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @GetMapping("getbroker/{key}/{bId}")
    public ResponseEntity<Broker> getBrokerByIdHandler(@PathVariable String key , @PathVariable Integer bId){

        Broker broker = adminService.getBrokerById(key,bId);

        return new ResponseEntity<>(broker, HttpStatus.OK);

    }


}
