package com.hospital.service;

import com.hospital.db.PatientRepository;
import com.hospital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Transactional
    public boolean signUp(String firstName, String lastName, String userName, String email, String password, String passwordConfirmation) {
        if (patientRepository.findByUserName(userName).size() >= 1) {
            System.out.println("This username already in use!");
            return false;
        } else if (!password.equals(passwordConfirmation)) {
            System.out.println("Password does not match");
            return false;
        } else {
            Patient patient = new Patient(firstName, lastName, userName, email, password);
            System.out.println("You have successfully registered");
            patientRepository.save(patient);
            return true;
        }
    }

    @Transactional
    public boolean logIn(String userName, String password) {
        if (patientRepository.findByUserName(userName).size() == 0) {
            System.out.println("Username is incorrect");
            return false;
        } else if (!patientRepository.findByUserName(userName).get(0).getPassword().equals(password)) {
            System.out.println("Password is incorrect");
            return false;
        } else {
            System.out.println("You have successfully logged in");
            return true;
        }
    }
}
