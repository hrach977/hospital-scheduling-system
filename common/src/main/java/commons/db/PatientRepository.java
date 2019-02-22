package commons.db;

import commons.entities.Patient;

public interface PatientRepository {
    Patient save(Patient patient);
}
