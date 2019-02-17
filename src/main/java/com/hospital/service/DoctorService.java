package com.hospital.service;

import com.hospital.db.DoctorRepository;
import com.hospital.entities.Doctor;
import com.hospital.entities.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    public Doctor updateDoctor(Long id,String username, String firstName, String lastName, Specialization specialization, String email, String phoneNumber){
        Doctor doctor = doctorRepository.findById(id);
        doctor.setUsername(username);
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setEmail(email);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phoneNumber);
        return doctor;
    }

//    public Doctor createDoctor(String username, String firstName, String lastName, Specialization specialization, String email, String phoneNumber,){
////        return doctorRepository.save(doctor);
//        Doctor doctor = new Doctor(username, firstName, lastName, specialization, email, phoneNumber);
//
//
//
//    }

    public boolean checkUsernameExists(String username) {
        if (null != doctorRepository.findByUsername(username)) {
            return true;
        }
        return false;
    }
    public boolean checkUserExists(String username, String email){
        if (checkUsernameExists(username) || checkEmailExists(username)) {
            return true;
        }
        return false;
    }

    private boolean checkEmailExists(String email) {
        if(null != doctorRepository.findByEmail(email)){
            return true;
        }
        return false;
    }

    public void deacttivate(Doctor doctor){
        doctorRepository.delete(doctor);
    }

    public List<Doctor> findDoctorsList(){
        return doctorRepository.findAll();
    }

    public List<Doctor> findDoctorsListBySpecialization(Specialization specialization){
        return doctorRepository.findBySpecialization(specialization);
    }

}
