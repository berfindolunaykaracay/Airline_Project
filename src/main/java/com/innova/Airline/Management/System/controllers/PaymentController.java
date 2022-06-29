package com.innova.Airline.Management.System.controllers;

import com.innova.Airline.Management.System.entities.Crew;
import com.innova.Airline.Management.System.entities.Payment;
import com.innova.Airline.Management.System.services.CrewService;
import com.innova.Airline.Management.System.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addPayment(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
        return new ResponseEntity<>(new ApiResponse(true, "created the payment"), HttpStatus.CREATED);

    }
    @GetMapping("/read")
    public ResponseEntity<List<Payment>> getPayment() {
        List<Payment> payments = paymentService.listCategories();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) {
        paymentService.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(true, "deleted the payment"), HttpStatus.OK);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateAdmin(@PathVariable("id") Long id, @Valid @RequestBody Payment payment) {

        paymentService.updatePayment(id, payment);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the payment"), HttpStatus.OK);
    }
}
