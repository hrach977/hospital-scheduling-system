package com.hospital.controller;

import com.hospital.db.PatientRepository;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Patient_controller {

    @Autowired
    @Qualifier("internal")
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    @PostMapping(value = "/signUp")
    @ResponseBody
    public String signUp(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                         @RequestParam("userName") String userName, @RequestParam("email") String email,
                         @RequestParam("password") String password, @RequestParam("passwordConfirmation") String passwordConfirmation) {
        if (patientService.signUp(firstName, lastName, userName, email, password, passwordConfirmation)) {
            return "You have signed up successfully";
        } else {
            return "You can not sign up";
        }
    }

    @PostMapping(value = "/logIn")
    @ResponseBody
    public String logIn(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        if (patientService.logIn(userName, password)) {
            return "You have logged in successfully";
        } else {
            return "Your userName or password is incorrect";
        }
    }

//    @GetMapping(value = "/showAllDoctors")
//    @ResponseBody
//    Iterable<Doctor> getAllHospitals(){
//        return doctorRepository.findAll();
//    }

}
