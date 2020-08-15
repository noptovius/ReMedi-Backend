package com.wincentzzz.project.template.springhack.services.impl;

import com.wincentzzz.project.template.springhack.models.Appointment;
import com.wincentzzz.project.template.springhack.repositories.AppointmentRepository;
import com.wincentzzz.project.template.springhack.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Page<Appointment> getAllAppointments(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }

    @Override
    public Appointment getAppointment(Long id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public void addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void updateAppointment(Long id, Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Page<Appointment> getFinishedAppointmentsByPatientId(Long patientId, Pageable pageable) {
        return appointmentRepository
                .findAppointmentsByPatientIdAndIsFinishedTrue(patientId, pageable);
    }

    @Override
    public Page<Appointment> getScheduledAppointmentsByPatientId(Long patientId, Pageable pageable) {
        return appointmentRepository
                .findAppointmentsByPatientIdAndIsFinishedFalse(patientId, pageable);
    }

    @Override
    public Page<Appointment> getAppointmentsByDoctorId(Long doctorId, Pageable pageable) {
        return appointmentRepository.findAppointmentsByDoctorId(doctorId, pageable);
    }
}
