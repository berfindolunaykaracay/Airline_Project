package com.innova.Airline.Management.System.controllers;

import com.innova.Airline.Management.System.entities.Passenger;
import com.innova.Airline.Management.System.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/passenger")
@CrossOrigin("*")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addPassenger(@RequestBody Passenger passenger) {
        passengerService.addPassenger(passenger);
        return new ResponseEntity<>(new ApiResponse(true, "created the passenger"), HttpStatus.CREATED);

    }

    @GetMapping("/read")
    public ResponseEntity<List<Passenger>> getPassenger() {
        List<Passenger> passengers = passengerService.listCategories();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deletePassenger(@RequestBody Passenger passenger) {
        passengerService.deletePassenger(passenger.getFirstName());

        return new ResponseEntity<>(new ApiResponse(true, "deleted the passenger"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) {
        passengerService.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(true, "deleted the passenger"), HttpStatus.OK);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updatePassenger(@PathVariable("id") Long id, @Valid @RequestBody Passenger passenger) {

        passengerService.updatePassenger(id, passenger);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the passenger"), HttpStatus.OK);
    }
}
