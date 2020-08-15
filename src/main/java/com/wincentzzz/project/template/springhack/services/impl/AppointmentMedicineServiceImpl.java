package com.wincentzzz.project.template.springhack.services.impl;

import com.wincentzzz.project.template.springhack.models.AppointmentMedicine;
import com.wincentzzz.project.template.springhack.repositories.AppointmentMedicineRepository;
import com.wincentzzz.project.template.springhack.services.AppointmentMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentMedicineServiceImpl implements AppointmentMedicineService {

    @Autowired
    private AppointmentMedicineRepository appointmentMedicineRepository;

    @Override
    public List<AppointmentMedicine> getAllAppointmentMedicines() {
        return appointmentMedicineRepository.findAll();
    }

    @Override
    public AppointmentMedicine getAppointmentMedicine(Long id) {
        return appointmentMedicineRepository.findById(id).get();
    }

    @Override
    public void addAppointmentMedicine(AppointmentMedicine appointmentMedicine) {
        appointmentMedicineRepository.save(appointmentMedicine);
    }

    @Override
    public void updateAppointmentMedicine(Long id, AppointmentMedicine appointmentMedicine) {
        appointmentMedicineRepository.save(appointmentMedicine);
    }

    @Override
    public void deleteAppointmentMedicine(Long id) {
        appointmentMedicineRepository.deleteById(id);
    }
}
