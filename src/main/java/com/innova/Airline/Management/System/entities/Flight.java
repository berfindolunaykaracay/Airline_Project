package com.innova.Airline.Management.System.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flight_id", nullable = false)
    private Long flight_id;
    private Date fdate;
    private String airplaneType;
    private String connectingFlight;
    private String ftime;
    private String airlineName;
    private String fromLocation;
    private String toLocation;
    private String departureTime;
    private int duration;

    @ManyToMany
    Set<Crew> clist;


}
