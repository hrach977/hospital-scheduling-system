package service.controllers;

import commons.db.PatientRepository;
import commons.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import service.services.PatientService;

import javax.validation.Valid;

@RestController//(value = "/patients") //("patients")
@RequestMapping//("/service/v1/patients")
@EnableJpaRepositories("commons")
public class PatientController {

//    @Autowired
//    PatientRepository patientRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;

    @PostMapping("/index")
    //@ResponseBody
    public String indexPatient() {
        System.out.println("inside index");
        Patient modular = new Patient();
        modular.setUsername("modularPatient3");
        patientRepository.save(modular);
        return "Hello From Modular Project";
    }

    @PostMapping("/signUp")
    public String signUpPatient(@RequestParam @Valid String username, @RequestParam @Valid String firstName,
                                @RequestParam @Valid String lastName, @RequestParam @Valid String password,
                                @RequestParam @Valid String passwordConfirmation, @RequestParam @Valid String email) {
        if (!patientService.signUp(username, firstName, lastName, password, passwordConfirmation, email)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This username already in use");
//            ResponseEntity<>("This username already in use",HttpStatus.BAD_REQUEST);
        }
//        return new ResponseEntity<>("You have registered successfully",HttpStatus.OK);
        return "";
    }
}
