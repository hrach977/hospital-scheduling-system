package com.hospital.repositories;

import com.hospital.entities.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
