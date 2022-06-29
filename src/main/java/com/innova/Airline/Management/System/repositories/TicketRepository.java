package com.innova.Airline.Management.System.repositories;

import com.innova.Airline.Management.System.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository <Ticket,Long> {
}
