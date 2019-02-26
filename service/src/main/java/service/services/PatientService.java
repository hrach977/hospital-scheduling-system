package service.services;

import commons.db.PatientRepository;
import commons.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Transactional
    public boolean signUp(String username, String firstName, String lastName, String password, String passwordConfirmation, String email) {
        if (patientRepository.findByUsername(username) == null) {
            Patient patient = new Patient(username, firstName, lastName, password, passwordConfirmation, email);
            patientRepository.save(patient);
            return true;
        } else return false;
    }
}
