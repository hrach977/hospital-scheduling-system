package com.hospital.controller;

import com.hospital.db.jpa.PatientRepository;
import com.hospital.entities.Patient;
import com.hospital.service.PatientSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


    @RestController
//@RequestMapping(value = "/homepage")
    public class UserController {

        @Autowired
        PatientRepository patientRepository;

        @Autowired
        PatientSignUpService patientSignUpService;



//        @RequestMapping(value = "/signUp", method = RequestMethod.GET)
//        @ModelAttribute
//        public String signUp(Model model) {
//            model.addAttribute("patientForm", new Patient());
//            return "signUp";
//        }

        @PostMapping(value = "/signUp")
        @ResponseBody
        public String signUp(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
                             @RequestParam("userName") String userName,@RequestParam("email") String email,
                             @RequestParam("password") String password,@RequestParam("passwordConfirmation") String passwordConfirmation) {
            patientSignUpService.signUp(firstName,lastName,userName,email,password,passwordConfirmation);
            Patient patient = new Patient(firstName,lastName,userName,email,password);
            System.out.println(new Patient(firstName,lastName,userName,email,password));
            patientRepository.save(patient);
            return "Signed up successfully";
        }


    }

