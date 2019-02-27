package service.services;

import commons.db.PatientRepository;
import commons.entities.Patient;
import commons.entities.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public boolean signUp(String username, String firstName, String lastName, String password, String passwordConfirmation, String email) {
        if (patientRepository.findByUsername(username) == null) {
            Patient patient = new Patient(username, firstName, lastName, password, passwordConfirmation, email);
            patient.setPassword(passwordEncoder.encode(patient.getPassword()));
            patient.setUserType(UserType.USER);
            patientRepository.save(patient);
            return true;
        } else return false;
    }
}
