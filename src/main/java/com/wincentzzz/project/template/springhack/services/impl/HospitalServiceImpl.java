package com.wincentzzz.project.template.springhack.services.impl;

import com.wincentzzz.project.template.springhack.models.Hospital;
import com.wincentzzz.project.template.springhack.repositories.HospitalRepository;
import com.wincentzzz.project.template.springhack.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital getHospital(Long id) {
        return hospitalRepository.findById(id).get();
    }

    @Override
    public void addHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public void updateHospital(Long id, Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public void deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
    }
}
