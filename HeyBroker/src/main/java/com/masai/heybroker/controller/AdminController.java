package com.masai.heybroker.controller;

import com.masai.heybroker.model.Admin;
import com.masai.heybroker.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdminHandler(@RequestBody Admin admin){

       Admin admin1 =  adminService.createAdmin(admin);

       return new ResponseEntity<Admin>(admin1, HttpStatus.CREATED);
    }
    @PutMapping("/update/{key}")
    public ResponseEntity<Admin>updateAdminHandler(@RequestBody Admin admin, @PathVariable String key){

          Admin admin1 =  adminService.updateAdmin(admin,key);

          return new ResponseEntity<Admin>(admin1,HttpStatus.OK);
    }
}
