package com.hospital.controller;

import com.hospital.db.jpa.PatientRepository;
import com.hospital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping(value = "person/test")
    public String indexPatient() {
        System.out.println("creating the patient");
        Patient patient = new Patient();
        patient.setUserName("hivand");
        patient.setFirstName("pacient");
        patient.setUserName("hivandyan");
        patient.setEmail("hivand@gmail.com");
        patient.setPassword("qwerty");
        System.out.println(patient);
        patientRepository.save(patient);
        return "Saved successfully";
    }
}
