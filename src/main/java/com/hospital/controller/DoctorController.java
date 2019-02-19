package com.hospital.controller;


import com.hospital.entities.Doctor;
import com.hospital.service.DoctorService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DoctorController {

//   private Logger logger = LoggerFactory.getLogger(DoctorController.class);

   @Autowired
   private DoctorService doctorService;

   @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
   @ResponseBody
   public String registerUserAccount(@RequestParam final Doctor accountDto) {
//      logger.debug("Registering user account with information: {}", accountDto);

      final Doctor registered = doctorService.createDoctor(accountDto);
      return "success";
   }



}
