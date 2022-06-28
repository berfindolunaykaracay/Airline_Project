package com.innova.Airline.Management.System.repository;

import com.innova.Airline.Management.System.entities.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository <Crew,Long> {
}
