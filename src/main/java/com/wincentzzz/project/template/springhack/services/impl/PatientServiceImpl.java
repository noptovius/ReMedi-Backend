package com.wincentzzz.project.template.springhack.services.impl;

import com.wincentzzz.project.template.springhack.models.Patient;
import com.wincentzzz.project.template.springhack.repositories.PatientRepository;
import com.wincentzzz.project.template.springhack.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    @Override
    public Patient getPatient(Long id) {
        Patient patient = patientRepository.findById(id).get();
        return patient;
    }

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void updatePatient(Long id, Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

//    @Override
//    public PatientResponse login() {
//        PatientResponse patientResponse = PatientResponse.builder()
//                .username("Username")
//                .password("Password")
//                .build();
//        return patientResponse;
//    }
}
