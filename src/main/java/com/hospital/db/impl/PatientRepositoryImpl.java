package com.hospital.db.impl;

import com.hospital.db.PatientRepository;
import com.hospital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "internal")
public class PatientRepositoryImpl implements PatientRepository {

    @Autowired
    private com.hospital.db.jpa.PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient) {
       return patientRepository.save(patient);
    }
}
