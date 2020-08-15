package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.request.AppointmentMedicineRequest;
import com.wincentzzz.project.template.springhack.models.Appointment;
import com.wincentzzz.project.template.springhack.models.AppointmentMedicine;
import com.wincentzzz.project.template.springhack.models.Medicine;

public class AppointmentMedicineMapper {

    public static AppointmentMedicine toAppointmentMedicine(AppointmentMedicineRequest appointmentMedicineRequest){
        return AppointmentMedicine.builder()
                .appointment(Appointment.builder()
                        .id(appointmentMedicineRequest.getAppointmentId())
                        .build())
                .medicine(Medicine.builder()
                        .id(appointmentMedicineRequest.getMedicineId())
                        .build())
                .weight(appointmentMedicineRequest.getWeight())
                .build();
    }
}
