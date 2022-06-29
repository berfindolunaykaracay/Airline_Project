package com.innova.Airline.Management.System.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @Column(unique = true)
    private String firstName;
    private String lastName;
    private String gender;
    private String profession;
    //private Date birthDate;
    private String passengerType;
    private String email;
    private int miles;
    private String phoneNumber;

}
