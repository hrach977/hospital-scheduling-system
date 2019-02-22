package service.controllers;

import commons.db.jpa.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//(value = "/patients") //("patients")
@RequestMapping("patients")
@EnableJpaRepositories("commons")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/index")
    //@ResponseBody
    public String indexPatient() {
        System.out.println("inside index");
        return "Hello From Modular Project";
    }
}
