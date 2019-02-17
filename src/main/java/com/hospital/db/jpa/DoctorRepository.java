package com.hospital.db.jpa;

import com.hospital.entities.Doctor;
import com.hospital.entities.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
   List<Doctor> findBySpecialization(Specialization specialization);
   Doctor findByUsername(String username);
   List<Doctor> findAll();
   Doctor findByEmail(String email);
   Doctor findById(Long id);
}
