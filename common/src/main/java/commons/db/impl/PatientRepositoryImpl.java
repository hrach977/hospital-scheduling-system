package commons.db.impl;

import commons.db.PatientRepository;
import commons.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("internal")
public class PatientRepositoryImpl implements PatientRepository {

    @Autowired
    private commons.db.jpa.PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findByUsername(String username) {
        return patientRepository.findByUsername(username);
    }
}
