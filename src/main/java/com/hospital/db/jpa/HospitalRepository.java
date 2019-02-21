package com.hospital.db.jpa;

import com.hospital.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    List<Hospital> findAll();

    List<Hospital> findByUsername(String userName);
}
