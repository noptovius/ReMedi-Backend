package com.wincentzzz.project.template.springhack.repositories;

import com.wincentzzz.project.template.springhack.models.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Page<Appointment> findAppointmentsByPatientIdAndIsFinishedTrue(Long patientId, Pageable pageable);
    Page<Appointment> findAppointmentsByPatientIdAndIsFinishedFalse(Long patientId, Pageable pageable);
}
