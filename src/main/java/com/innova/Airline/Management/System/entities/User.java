package com.innova.Airline.Management.System.entities;

import lombok.Data;

import javax.persistence.*;

@Data
public class User {


    private String email;
    private String password;

}
