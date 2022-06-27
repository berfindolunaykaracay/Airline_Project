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
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String gender;
    private String lastName;
    private String firstName;
    private String profession;
    private Date birthDate;
    private String passengerType;
    private String email;
    private int miles;
    private String phoneNumber;

}
