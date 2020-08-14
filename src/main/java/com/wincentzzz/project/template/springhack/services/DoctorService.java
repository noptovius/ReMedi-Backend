package com.wincentzzz.project.template.springhack.services;

import com.wincentzzz.project.template.springhack.models.Doctor;
import com.wincentzzz.project.template.springhack.models.Patient;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();
    Doctor getDoctor(Long id);
    void addDoctor(Doctor patient);
    void updateDoctor(Long id, Doctor patient);
    void deleteDoctor(Long id);
}
