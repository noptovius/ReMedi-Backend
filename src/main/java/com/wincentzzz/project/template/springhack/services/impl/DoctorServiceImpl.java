package com.wincentzzz.project.template.springhack.services.impl;

import com.wincentzzz.project.template.springhack.models.Doctor;
import com.wincentzzz.project.template.springhack.repositories.DoctorRepository;
import com.wincentzzz.project.template.springhack.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    private final Integer SIZE = 10;

    @Override
    public Page<Doctor> getAllDoctors(String doctorName, String specialization, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, SIZE);
        return doctorRepository.findDoctorsByNameLikeAndSpecializationLike(doctorName, specialization, pageable);
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
