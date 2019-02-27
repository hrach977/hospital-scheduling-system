package service.controllers;

import commons.db.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.services.HospitalService;

@RestController
@EnableJpaRepositories("common")
//@ComponentScan("service.services")
@RequestMapping("api/hospitals")
public class HospitalController {

//    @Autowired
//    HospitalRepository hospitalRepository;

    @Autowired
    HospitalService hospitalService;

    @PostMapping("/register")
    public String registerHospital(@RequestParam String name, @RequestParam String username,
                                   @RequestParam String password, @RequestParam String address,
                                   @RequestParam String email, @RequestParam String phone) {
        System.out.println("got request from client");
        hospitalService.registerHospital(name, password, username, address, email, phone);
        return "Registered successfully";
    }


//    private String name;
//    private String username;
//    private String password;
//    private String address;
//    private String phone;
//    private String email;
}
