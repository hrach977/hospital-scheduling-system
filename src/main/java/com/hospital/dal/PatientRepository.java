package com.hospital.dal;

import com.hospital.entities.Patient;

public interface PatientRepository {

     Patient findByUsername(String username);
}
