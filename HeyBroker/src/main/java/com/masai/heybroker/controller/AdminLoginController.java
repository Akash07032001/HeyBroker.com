package com.masai.heybroker.controller;

import com.masai.heybroker.model.AdminLoginDTO;
import com.masai.heybroker.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/adminlogin")
public class AdminLoginController {
    @Autowired
    private AdminLoginService adminLoginService;

    @PostMapping("/login")
    public ResponseEntity<String> adminLoginHandler(@Valid @RequestBody AdminLoginDTO adminLoginDTO){

       String key= adminLoginService.logIntoAccount(adminLoginDTO);
        return new ResponseEntity<String>(key, HttpStatus.ACCEPTED);
    }

    @GetMapping("/logout/{key}")
    public ResponseEntity<String> adminLogoutHandler(@PathVariable String key){

        String key1 = adminLoginService.logOutFromAccount(key);
        return new ResponseEntity<String>(key1, HttpStatus.ACCEPTED);
    }
}
