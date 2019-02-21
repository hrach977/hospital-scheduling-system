package com.hospital.db.impl;

import com.hospital.db.HospitalRepository;
import com.hospital.entities.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "internalHospital")
public class HospitalRepositoryImpl implements HospitalRepository {

    @Autowired
    com.hospital.db.jpa.HospitalRepository hospitalRepository;

    @Override
    public List<Hospital> findAll() {
        return hospitalRepository.findAll();
    }

    @Override
    public List<Hospital> findByUsername(String userName) {
        return hospitalRepository.findByUsername(userName);
    }

    @Override
    public Hospital save(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
}
