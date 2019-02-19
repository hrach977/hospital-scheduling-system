package com.hospital.db.impl;

import com.hospital.db.DoctorRepository;
import com.hospital.entities.Doctor;
import com.hospital.entities.Specialization;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DoctorRepositoryImpl implements DoctorRepository {

   @Autowired
   private com.hospital.db.jpa.DoctorRepository doctorRepository;


   public List<Doctor> findBySpecialization(Specialization specialization) {
      return doctorRepository.findBySpecialization(specialization);
   }
//
//   public Doctor findByUsername(String username) {
//
//      return doctorRepository.findByUsername(username);
//   }
//
//   public List<Doctor> findAll() {
//
//      return doctorRepository.findAll();
//   }
//
//   public Doctor findByEmail(String email) {
//      return doctorRepository.findByEmail(email);
//   }
//   public void delete(Doctor doctor){
//      doctorRepository.delete(doctor);
//   }
//
//   public Doctor findById(Long id) {
//      return doctorRepository.findById(id);
//   }

//   public Doctor save(Doctor doctor) {
//      return doctorRepository.save(doctor);
//   }
}
