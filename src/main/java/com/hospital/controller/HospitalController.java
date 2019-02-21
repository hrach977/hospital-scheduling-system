package com.hospital.controller;

import com.hospital.db.HospitalRepository;
import com.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {

    @Autowired
    @Qualifier("internalHospital")
    HospitalRepository hospitalRepository;

    @Autowired
    HospitalService hospitalService;

    @PostMapping(value = "/hospitalSignUp")
    @ResponseBody
    public String signUp(@RequestParam("name") String name, @RequestParam("userName") String userName,
                         @RequestParam("password") String password, @RequestParam("passwordConfirmation") String passwordConfirmation,
                         @RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber,
                         @RequestParam("address") String address) {
        if (hospitalService.signUp(name, userName, password, passwordConfirmation, email, phoneNumber, address)) {
            return "You have signed up successfully";
        } else {
            return "You can not sign up";
        }
    }

    @PostMapping(value = "/hospitalLogIn")
    @ResponseBody
    public String logIn(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        if (hospitalService.logIn(userName, password)) {
            return "You have logged in successfully";
        } else {
            return "Your userName or password is incorrect";
        }
    }


}
