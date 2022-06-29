package com.innova.Airline.Management.System.services;

import com.innova.Airline.Management.System.entities.Passenger;
import com.innova.Airline.Management.System.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public void addPassenger(Passenger passenger) {

        passengerRepository.save(passenger);
    }

    public Passenger readPassenger(String passengerName) {

        return passengerRepository.findByFirstName(passengerName);
    }

    public List<Passenger> listCategories() {
        return passengerRepository.findAll();
    }

    public void deletePassenger(String passengerFname) {
        passengerRepository.deleteByFirstName(passengerFname);
    }

    public void deleteById(Long id) {
        passengerRepository.deleteById(id);
    }

    public void updatePassenger(Long id, Passenger passenger) {
        Passenger oldPassenger = passengerRepository.findById(id).get();
        oldPassenger.setFirstName(passenger.getFirstName());
        oldPassenger.setLastName(passenger.getLastName());
        oldPassenger.setGender(passenger.getGender());
        oldPassenger.setProfession(passenger.getProfession());
        oldPassenger.setPassengerType(passenger.getPassengerType());
        oldPassenger.setEmail(passenger.getEmail());
        oldPassenger.setMiles(passenger.getMiles());
        oldPassenger.setPhoneNumber(passenger.getPhoneNumber());
        passengerRepository.save(oldPassenger);
    }
}
