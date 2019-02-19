package com.hospital.service;

import com.hospital.db.jpa.PatientRepository;
import com.hospital.entities.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientSignUpService {

//        private static final Logger logger = LoggerFactory.getLogger(PatientSignUpService.class);

        @Autowired
        PatientRepository patientRepository;

        @Transactional
        public boolean signUp(String firstName, String lastName, String userName, String email, String password, String passwordConfirmation){
//            logger.debug("signUp service");
            if(patientRepository.findByUserName(userName) != null){
//                logger.error("This username already in use!");
                return false;
            }
            else if(password != passwordConfirmation){
//                logger.error("Password does not match");
                return false;
            }
            else{
                Patient patient = new Patient(firstName,lastName,userName,email,password);
//                logger.info("You have successfully registered.");
                patientRepository.save(patient);

                return true;
            }
        }

    }


