package com.innova.Airline.Management.System.services;

import com.innova.Airline.Management.System.entities.Passenger;
import com.innova.Airline.Management.System.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginService {
    @Autowired
    private PassengerRepository passengerRepository;


    public Passenger findUser(String email) {
        return passengerRepository.findByEmail(email);
    }
}
