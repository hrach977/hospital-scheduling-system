package com.hospital.service;

import com.hospital.db.HospitalRepository;
import com.hospital.entities.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Transactional
    public boolean signUp(String name, String userName, String password, String passwordConfirmation,
                          String email, String phoneNumber, String address) {
        if (hospitalRepository.findByUsername(userName).size() >= 1) {
            System.out.println("This username already in use!");
            return false;
        } else if (!password.equals(passwordConfirmation)) {
            System.out.println("Password does not match");
            return false;
        } else {
            Hospital hospital = new Hospital(name, userName, password, email, phoneNumber, address);
            System.out.println("You have successfully registered.");
            hospitalRepository.save(hospital);

            return true;
        }
    }

    @Transactional
    public boolean logIn(String userName, String password) {
        if (hospitalRepository.findByUsername(userName).size() == 0) {
            System.out.println("Username is incorrect");
            return false;
        } else if (!hospitalRepository.findByUsername(userName).get(0).getPassword().equals(password)) {
            System.out.println("Password is incorrect");
            return false;
        } else {
            System.out.println("You have successfully logged in");
            return true;
        }
    }
}
