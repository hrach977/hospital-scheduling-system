package com.hospital.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "hospital_id")
    private Long hospitalId;
    @Column(name = "doctor_id")
    private Long doctorId;
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;
    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;

    public Appointment() {}

    public Appointment(Long hospitalId, Long doctorId, Long patientId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.hospitalId = hospitalId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getId() {
        return id;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}



