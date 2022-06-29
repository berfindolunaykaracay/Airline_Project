package com.innova.Airline.Management.System.repositories;

import com.innova.Airline.Management.System.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository <Passenger,Long> {
    Passenger findByFirstName(String firstname);

    void deleteByFirstName(String firstname);
}