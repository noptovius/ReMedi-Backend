package com.wincentzzz.project.template.springhack.services.impl;

import com.wincentzzz.project.template.springhack.models.Patient;
import com.wincentzzz.project.template.springhack.repositories.PatientRepository;
import com.wincentzzz.project.template.springhack.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatient(Long id) {
        return patientRepository.findById(id).get();
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

    @Override
    public void unlockPatient(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()) {
            Patient patientData = patient.get();
            if(patientData.getUnlock()) {
                patientData.setUnlock(false);
            } else {
                patientData.setUnlock(true);
            }
        }
    }
}
