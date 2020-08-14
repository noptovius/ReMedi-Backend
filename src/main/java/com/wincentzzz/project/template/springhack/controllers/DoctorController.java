package com.wincentzzz.project.template.springhack.controllers;

import com.wincentzzz.project.template.springhack.dto.request.DoctorRequest;
import com.wincentzzz.project.template.springhack.dto.request.PatientRequest;
import com.wincentzzz.project.template.springhack.dto.response.DoctorListResponse;
import com.wincentzzz.project.template.springhack.dto.response.PatientListResponse;
import com.wincentzzz.project.template.springhack.dto.response.PatientResponse;
import com.wincentzzz.project.template.springhack.mapper.DoctorMapper;
import com.wincentzzz.project.template.springhack.mapper.PatientMapper;
import com.wincentzzz.project.template.springhack.models.Doctor;
import com.wincentzzz.project.template.springhack.models.Patient;
import com.wincentzzz.project.template.springhack.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<DoctorListResponse> getAllDoctors(){
        return DoctorMapper.toDoctorlistResponse(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public PatientResponse getDoctor(@PathVariable Long id){
        return DoctorMapper.toDoctorResponse(doctorService.getDoctor(id));
    }

    @PostMapping
    public void addDoctor(@RequestBody DoctorRequest doctorRequest){
        Doctor patient = DoctorMapper.toDoctor(doctorRequest);
        doctorService.addDoctor(patient);
    }

    @PutMapping("/{id}")
    public void updateDoctor(@PathVariable Long id, @RequestBody DoctorRequest doctorRequest){
        Doctor doctor = DoctorMapper.toDoctor(doctorRequest);
        doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
    }
}
