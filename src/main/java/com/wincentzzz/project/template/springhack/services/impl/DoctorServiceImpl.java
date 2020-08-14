package com.wincentzzz.project.template.springhack.services.impl;

import com.wincentzzz.project.template.springhack.models.Doctor;
import com.wincentzzz.project.template.springhack.repositories.DoctorRepository;
import com.wincentzzz.project.template.springhack.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctor(Long id) {
        return doctorRepository.getOne(id);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void updateDoctor(Long id, Doctor doctor) {
        doctor.setId(id);
        doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
