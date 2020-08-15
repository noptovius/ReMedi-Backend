package com.wincentzzz.project.template.springhack.services;

import com.wincentzzz.project.template.springhack.models.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment getAppointment(Long id);
    void addAppointment(Appointment appointment);
    void updateAppointment(Long id, Appointment appointment);
    void deleteAppointment(Long id);

    Page<Appointment> getFinishedAppointmentsByPatientId(Long patientId, Pageable pageable);
    Page<Appointment> getScheduledAppointmentsByPatientId(Long patientId, Pageable pageable);
}
