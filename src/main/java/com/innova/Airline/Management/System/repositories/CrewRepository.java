package com.innova.Airline.Management.System.repositories;

import com.innova.Airline.Management.System.entities.Admin;
import com.innova.Airline.Management.System.entities.Crew;
import com.innova.Airline.Management.System.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository <Crew,Long> {


}
