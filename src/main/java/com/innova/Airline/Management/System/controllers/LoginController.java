package com.innova.Airline.Management.System.controllers;


import ch.qos.logback.core.status.Status;
import com.innova.Airline.Management.System.entities.Passenger;
import com.innova.Airline.Management.System.entities.User;
import com.innova.Airline.Management.System.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/signin")
    public ApiResponse loginUser(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        Passenger founduser = loginService.findUser(email);

        if(founduser.getPassword().equals(password)){
            return new ApiResponse(true,"Login is successful");
        }
        return new ApiResponse(false,"Login is unsuccessful");
    }
}
