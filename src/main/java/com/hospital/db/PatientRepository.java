package com.hospital.db;

import com.hospital.entities.Patient;

import java.util.List;

public interface PatientRepository {
    Patient save(Patient patient);

    List<Patient> findByUserName(String userName);
}
