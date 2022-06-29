package com.innova.Airline.Management.System.services;

import com.innova.Airline.Management.System.entities.Crew;
import com.innova.Airline.Management.System.entities.Ticket;
import com.innova.Airline.Management.System.repositories.CrewRepository;
import com.innova.Airline.Management.System.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public void addTicket(Ticket ticket) {

        ticketRepository.save(ticket);
    }

    public List<Ticket> listCategories() {

        return ticketRepository.findAll();
    }

    public void deleteById(Long id) {

        ticketRepository.deleteById(id);
    }

    public void updateCrew(Long id, Ticket ticket) {
        Ticket oldTicket = ticketRepository.findById(id).get();
        oldTicket.setCancel(ticket.getCancel());
        oldTicket.setDelay(ticket.getDelay());
        oldTicket.setClassType(ticket.getClassType());
        oldTicket.setTcolumn(ticket.getTcolumn());
        oldTicket.setTrow(ticket.getTrow());
        oldTicket.setGate(ticket.getGate());
        ticketRepository.save(oldTicket);
    }
}
