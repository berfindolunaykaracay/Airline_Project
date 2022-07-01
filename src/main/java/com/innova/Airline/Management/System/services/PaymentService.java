package com.innova.Airline.Management.System.services;

import com.innova.Airline.Management.System.entities.Crew;
import com.innova.Airline.Management.System.entities.Payment;
import com.innova.Airline.Management.System.repositories.CrewRepository;
import com.innova.Airline.Management.System.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    public void addPayment(Payment payment) {

        paymentRepository.save(payment);
    }

    public List<Payment> listCategories() {

        return paymentRepository.findAll();
    }

    public void deleteById(Long id) {

        paymentRepository.deleteById(id);
    }

    public void updatePayment(Long id, Payment payment) {
        Payment oldPayment = paymentRepository.findById(id).get();
        oldPayment.setCardExpressionDate(payment.getCardExpressionDate());
        oldPayment.setCardname(payment.getCardname());
        oldPayment.setCardSecurityNumber(payment.getCardSecurityNumber());
        oldPayment.setPrice(payment.getPrice());

        paymentRepository.save(oldPayment);
    }
}
