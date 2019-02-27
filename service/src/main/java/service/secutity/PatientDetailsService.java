package service.secutity;

import commons.db.PatientRepository;
import commons.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("patientDetailsService")
public class PatientDetailsService implements UserDetailsService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Patient patient = patientRepository.findByUsername(username);
        if (patient == null) {
            throw new UsernameNotFoundException(String.format("User with username %s not found", username));
        }
        return new CurrentPatient(patient);
    }
}
