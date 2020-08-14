package com.wincentzzz.project.template.springhack.services;

import com.wincentzzz.project.template.springhack.models.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> getAllHospitals();
    Hospital getHospital(Long id);
    void addHospital(Hospital hospital);
    void updateHospital(Long id, Hospital hospital);
    void deleteHospital(Long id);
}
