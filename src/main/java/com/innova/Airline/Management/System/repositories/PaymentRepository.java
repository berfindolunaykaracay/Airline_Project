package com.innova.Airline.Management.System.repositories;

import com.innova.Airline.Management.System.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository <Payment,Long> {
}
