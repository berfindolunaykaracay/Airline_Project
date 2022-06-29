package com.innova.Airline.Management.System.controllers;

import com.innova.Airline.Management.System.entities.Admin;
import com.innova.Airline.Management.System.entities.Crew;
import com.innova.Airline.Management.System.entities.Passenger;
import com.innova.Airline.Management.System.services.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/crew")
public class CrewController {

    @Autowired
    private CrewService crewService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCrew(@RequestBody Crew crew) {
        crewService.addCrew(crew);
        return new ResponseEntity<>(new ApiResponse(true, "created the crew"), HttpStatus.CREATED);

    }

    @GetMapping("/read")
    public ResponseEntity<List<Crew>> getCrew() {
        List<Crew> crews = crewService.listCategories();
        return new ResponseEntity<>(crews, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) {
        crewService.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(true, "deleted the crew"), HttpStatus.OK);

    }
    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateAdmin(@PathVariable("id") Long id, @Valid @RequestBody Crew crew) {

        crewService.updateCrew(id, crew);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the crew"), HttpStatus.OK);
    }

}
