package com.wincentzzz.project.template.springhack.controllers;

import com.wincentzzz.project.template.springhack.dto.request.AppointmentMedicineRequest;
import com.wincentzzz.project.template.springhack.dto.response.BaseResponse;
import com.wincentzzz.project.template.springhack.mapper.AppointmentMedicineMapper;
import com.wincentzzz.project.template.springhack.models.AppointmentMedicine;
import com.wincentzzz.project.template.springhack.services.AppointmentMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/appointment/medicine")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppointmentMedicineController {

    @Autowired
    private AppointmentMedicineService appointmentMedicineService;

    @PostMapping
    public BaseResponse<Void> addAppointmentMedicine(
            @RequestBody AppointmentMedicineRequest appointmentMedicineRequest) {
        AppointmentMedicine appointmentMedicine =
                AppointmentMedicineMapper.toAppointmentMedicine(appointmentMedicineRequest);
        appointmentMedicineService.addAppointmentMedicine(appointmentMedicine);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Void> deletePatient(@PathVariable Long id){
        appointmentMedicineService.deleteAppointmentMedicine(id);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }
}
