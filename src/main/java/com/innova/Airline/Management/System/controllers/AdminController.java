package com.innova.Airline.Management.System.controllers;


import com.innova.Airline.Management.System.entities.Admin;
import com.innova.Airline.Management.System.entities.Passenger;
import com.innova.Airline.Management.System.services.AdminService;
import com.innova.Airline.Management.System.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
        return new ResponseEntity<>(new ApiResponse(true, "created the admin"), HttpStatus.CREATED);

    }

    @GetMapping("/read")
    public ResponseEntity<List<Admin>> getAdmin() {
        List<Admin> admins = adminService.listCategories();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) {
        adminService.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(true, "deleted the admin"), HttpStatus.OK);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateAdmin(@PathVariable("id") Long id, @Valid @RequestBody Admin admin) {

        adminService.updateAdmin(id, admin);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the admin"), HttpStatus.OK);
    }
}
