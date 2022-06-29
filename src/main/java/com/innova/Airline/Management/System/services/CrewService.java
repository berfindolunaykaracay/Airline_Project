package com.innova.Airline.Management.System.services;

import com.innova.Airline.Management.System.entities.Admin;
import com.innova.Airline.Management.System.entities.Crew;
import com.innova.Airline.Management.System.entities.Passenger;
import com.innova.Airline.Management.System.repositories.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewService {
    @Autowired
    private CrewRepository crewRepository;

    public void addCrew(Crew crew) {

        crewRepository.save(crew);
    }

    public List<Crew> listCategories() {

        return crewRepository.findAll();
    }

    public void deleteById(Long id) {

        crewRepository.deleteById(id);
    }

    public void updateCrew(Long id, Crew crew) {
        Crew oldCrew = crewRepository.findById(id).get();
        oldCrew.setCrewgender(crew.getCrewgender());
        oldCrew.setCrewname(crew.getCrewname());
        oldCrew.setEmail(crew.getEmail());
        oldCrew.setRole(crew.getRole());
        oldCrew.setSalary(crew.getSalary());
        crewRepository.save(oldCrew);
    }
}