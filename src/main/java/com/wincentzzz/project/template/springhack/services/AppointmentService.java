package com.wincentzzz.project.template.springhack.services;

import com.wincentzzz.project.template.springhack.models.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface AppointmentService {
    Page<Appointment> getAllAppointments(Pageable pageable);
    Appointment getAppointment(Long id);
    void addAppointment(Appointment appointment);
    void updateAppointment(Long id, Appointment appointment);
    void deleteAppointment(Long id);

    Page<Appointment> getFinishedAppointmentsByPatientId(Long appointmentId, Pageable pageable);
    Page<Appointment> getScheduledAppointmentsByPatientId(Long appointmentId, Pageable pageable);
}
