package com.innova.Airline.Management.System.services;

import com.innova.Airline.Management.System.entities.Admin;
import com.innova.Airline.Management.System.entities.Passenger;
import com.innova.Airline.Management.System.repositories.AdminRepository;
import com.innova.Airline.Management.System.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public void addAdmin(Admin admin) {

        adminRepository.save(admin);
    }
    public List<Admin> listCategories() {

        return adminRepository.findAll();
    }

    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    public void updateAdmin(Long id, Admin admin) {
        Admin oldAdmin = adminRepository.findById(id).get();
        oldAdmin.setAdminmail(admin.getAdminmail());
        oldAdmin.setAdminname(admin.getAdminname());
        oldAdmin.setAdminpassword(admin.getAdminpassword());
        adminRepository.save(oldAdmin);
    }}