package com.hospital.db;

import com.hospital.entities.Hospital;

import java.util.List;

public interface HospitalRepository {
    List<Hospital> findAll();

    List<Hospital> findByUsername(String userName);
}
