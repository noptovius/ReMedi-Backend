package com.wincentzzz.project.template.springhack.services;

import com.wincentzzz.project.template.springhack.models.Patient;

import java.util.List;


public interface PatientService {

    List<Patient> getAllPatients();
    Patient getPatient(Long id);
    void addPatient(Patient patient);
    void updatePatient(Long id, Patient patient);
    void deletePatient(Long id);

}
