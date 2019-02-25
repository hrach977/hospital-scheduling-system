package commons.db.impl;

import commons.db.HospitalRepository;
import commons.entities.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("internal_hostpital")
public class HospitalRepositoryImpl implements HospitalRepository {
    @Autowired
    private commons.db.jpa.HospitalRepository hospitalRepository;

    @Override
    public Hospital save(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
}
