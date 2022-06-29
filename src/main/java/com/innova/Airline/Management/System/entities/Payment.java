package com.innova.Airline.Management.System.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "payment")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cardno", nullable = false)
    private Long cardno;

   // private Date cardExpressionDate;
    private String cardname;
    private int cardSecurityNumber;
    private int price;
     @ManyToOne
     @JoinColumn(name = "passenger_id")
     private Passenger passenger;

}
