package com.innova.Airline.Management.System.controllers;

import com.innova.Airline.Management.System.entities.Crew;
import com.innova.Airline.Management.System.entities.Ticket;
import com.innova.Airline.Management.System.services.CrewService;
import com.innova.Airline.Management.System.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
        return new ResponseEntity<>(new ApiResponse(true, "created the ticket"), HttpStatus.CREATED);

    }

    @GetMapping("/read")
    public ResponseEntity<List<Ticket>> getTicket() {
        List<Ticket> tickets = ticketService.listCategories();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) {
        ticketService.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(true, "deleted the ticket"), HttpStatus.OK);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateAdmin(@PathVariable("id") Long id, @Valid @RequestBody Ticket ticket) {

        ticketService.updateCrew(id, ticket);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the ticket"), HttpStatus.OK);
    }
}
