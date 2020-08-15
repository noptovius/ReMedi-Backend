package com.wincentzzz.project.template.springhack.services;

import com.wincentzzz.project.template.springhack.models.AppointmentMedicine;

import java.util.List;

public interface AppointmentMedicineService {
    List<AppointmentMedicine> getAllAppointmentMedicines();
    AppointmentMedicine getAppointmentMedicine(Long id);
    void addAppointmentMedicine(AppointmentMedicine appointmentMedicine);
    void updateAppointmentMedicine(Long id, AppointmentMedicine appointmentMedicine);
    void deleteAppointmentMedicine(Long id);
}
