package com.innova.Airline.Management.System.repository;

import com.innova.Airline.Management.System.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository <Admin,Long> {
}
