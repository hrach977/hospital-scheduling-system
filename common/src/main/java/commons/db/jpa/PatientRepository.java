package commons.db.jpa;

import commons.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByUsername(String username);
}
