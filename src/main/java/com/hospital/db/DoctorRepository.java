package com.hospital.db;

import com.hospital.entities.Doctor;
import com.hospital.entities.Hospital;
import com.hospital.entities.Specialization;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;


@Repository
public interface DoctorRepository {

   List<Doctor> findBySpecialization(Specialization specialization);
   Doctor findByUsername(String username);
   List<Doctor> findAll();
   Doctor findByEmail(String email);
   void delete(Doctor doctor);
   Doctor findById(Long id);
   Doctor save(Doctor doctor);

}
