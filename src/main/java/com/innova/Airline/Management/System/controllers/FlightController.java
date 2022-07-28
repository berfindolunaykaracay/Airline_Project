package com.innova.Airline.Management.System.controllers;

import com.innova.Airline.Management.System.entities.Admin;
import com.innova.Airline.Management.System.entities.Flight;
import com.innova.Airline.Management.System.services.AdminService;
import com.innova.Airline.Management.System.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flight")
@CrossOrigin("*")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addFlight(@RequestBody Flight flight) {
        flightService.addFlight(flight);
        return new ResponseEntity<>(new ApiResponse(true, "created the admin"), HttpStatus.CREATED);

    }

    @GetMapping("/read")
    public ResponseEntity<List<Flight>> getFlight() {
        List<Flight> flights = flightService.listCategories();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) {
        flightService.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(true, "deleted the flight"), HttpStatus.OK);

    }
    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateFlight(@PathVariable("id") Long id, @Valid @RequestBody Flight flight) {

        flightService.updateFlight(id, flight);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the flight"), HttpStatus.OK);
    }
}
