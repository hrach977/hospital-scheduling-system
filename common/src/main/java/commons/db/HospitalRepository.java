package commons.db;

import commons.entities.Hospital;

public interface HospitalRepository {
    Hospital save(Hospital hospital);
}
