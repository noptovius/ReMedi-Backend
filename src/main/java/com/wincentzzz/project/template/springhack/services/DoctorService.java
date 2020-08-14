package com.wincentzzz.project.template.springhack.services;

import com.wincentzzz.project.template.springhack.models.Doctor;
import com.wincentzzz.project.template.springhack.models.Patient;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DoctorService {

    Page<Doctor> getAllDoctors(String doctorName, String specialization, Integer pageNumber);
    Doctor getDoctor(Long id);
    void addDoctor(Doctor patient);
    void updateDoctor(Long id, Doctor patient);
    void deleteDoctor(Long id);
}
