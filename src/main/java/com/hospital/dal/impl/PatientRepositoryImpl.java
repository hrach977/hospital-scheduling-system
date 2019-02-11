package com.hospital.dal.impl;

import com.hospital.dal.PatientRepository;
import com.hospital.entities.Patient;

public class PatientRepositoryImpl implements PatientRepository {
    public Patient findByUsername(String username) {
        System.out.println("getByUsername is invoked");
        return new Patient("first", "last", "username", "email", "password");
    }
}
