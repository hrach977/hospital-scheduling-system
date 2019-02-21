package com.hospital.db;

import com.hospital.entities.Patient;

public interface PatientRepository {
    Patient save(Patient patient);
}
