package com.innova.Airline.Management.System.services;

import com.innova.Airline.Management.System.entities.Admin;
import com.innova.Airline.Management.System.entities.Flight;
import com.innova.Airline.Management.System.repositories.AdminRepository;
import com.innova.Airline.Management.System.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public void addFlight(Flight flight) {

        flightRepository.save(flight);
    }

    public List<Flight> listCategories() {

        return flightRepository.findAll();
    }

    public void deleteById(Long id) {
        flightRepository.deleteById(id);
    }
    public void updateFlight(Long id, Flight flight) {
        Flight oldFlight = flightRepository.findById(id).get();
        oldFlight.setFlightdate(flight.getFlightdate());
        oldFlight.setAirplaneType(flight.getAirplaneType());
        oldFlight.setConnectingFlight(flight.getConnectingFlight());
        oldFlight.setFtime(flight.getFtime());
        oldFlight.setAirlineName(flight.getAirlineName());
        oldFlight.setFromLocation(flight.getFromLocation());
        oldFlight.setToLocation(flight.getToLocation());
        oldFlight.setDepartureTime(flight.getDepartureTime());
        oldFlight.setDuration(flight.getDuration());

        flightRepository.save(oldFlight);
    }
}
