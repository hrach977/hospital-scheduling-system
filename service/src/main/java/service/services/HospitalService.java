package service.services;

import commons.db.HospitalRepository;
import commons.entities.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    public Hospital registerHospital(String name,  String username, String password,  String address, String email,  String phone) {
        Hospital hospital = new Hospital(name, username, password, address, email, phone);
        return hospitalRepository.save(hospital);
    }
}
