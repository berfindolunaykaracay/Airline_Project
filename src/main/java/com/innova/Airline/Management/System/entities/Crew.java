package com.innova.Airline.Management.System.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "crew_id", nullable = false)
    private Long crew_id;

    private String email;
    private String crewgender;
    private String crewname;
    private String role;
    private int salary;

    @ManyToOne
    @JoinColumn(name = "admin_admin_id")
    private Admin admin;

    @ManyToMany
    Set<Flight> flist;

}
