package com.innova.Airline.Management.System.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id", nullable = false)
    private Long admin_id;
    private String adminname;
    private String adminmail;
    private String adminpassword;



}
