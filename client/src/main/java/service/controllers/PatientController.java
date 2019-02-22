package service.controllers;

import commons.db.jpa.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/patients")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/index")
    public String indexPatient() {
        System.out.println("inside index");
        return null;
    }
}
