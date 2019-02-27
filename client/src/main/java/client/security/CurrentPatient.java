package client.security;

import commons.entities.Patient;
import commons.entities.UserType;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentPatient extends org.springframework.security.core.userdetails.User {

    private Patient patient;

    public CurrentPatient(Patient patient) {
        super(patient.getUsername(), patient.getPassword(), AuthorityUtils.createAuthorityList(patient.getUserType().name()));
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public Long getId() {
        return patient.getId();
    }

    public UserType getUserType() {
        return patient.getUserType();
    }
}
