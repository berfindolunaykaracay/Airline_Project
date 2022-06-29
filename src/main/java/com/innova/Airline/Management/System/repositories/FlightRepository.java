package com.innova.Airline.Management.System.repositories;

import com.innova.Airline.Management.System.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository <Flight,Long> {
}
