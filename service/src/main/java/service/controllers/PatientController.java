package service.controllers;

import commons.db.PatientRepository;
import commons.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.services.PatientService;

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
    public ResponseEntity signUpPatient(@RequestParam String username, @RequestParam String firstName, @RequestParam String lastName,
                                        @RequestParam String password, @RequestParam String passwordConfirmation, @RequestParam String email) {
        if (!patientService.signUp(username, firstName, lastName, password, passwordConfirmation, email)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This username is already used");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("You have registered successfully");
    }
}
