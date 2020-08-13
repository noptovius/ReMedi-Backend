package com.wincentzzz.project.template.springhack.controllers;

import com.wincentzzz.project.template.springhack.dto.request.PatientRequest;
import com.wincentzzz.project.template.springhack.dto.response.BaseResponse;
import com.wincentzzz.project.template.springhack.dto.response.PatientListResponse;
import com.wincentzzz.project.template.springhack.dto.response.PatientResponse;
import com.wincentzzz.project.template.springhack.mapper.PatientMapper;
import com.wincentzzz.project.template.springhack.models.Patient;
import com.wincentzzz.project.template.springhack.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

//    @GetMapping
//    private BaseResponse<PatientResponse> test() {
//        PatientResponse patientResponse = patientService.login();
//        return BaseResponse.<PatientResponse>builder()
//                .code(200)
//                .data(patientResponse)
//                .build();
//    }

    @GetMapping
    public List<PatientListResponse> getAllPatients(){
        return PatientMapper.toListOfPatientResponse(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public PatientResponse getPatient(@PathVariable Long id){
        return PatientMapper.toPatientResponse(patientService.getPatient(id));
    }

    @PostMapping
    public void addPatient(@RequestBody PatientRequest patientRequest){
        Patient patient = PatientMapper.toPatient(patientRequest);
        patientService.addPatient(patient);
    }

    @PutMapping("/{id}")
    public void updatePatient(@PathVariable Long id, @RequestBody PatientRequest patientRequest){
        Patient patient = PatientMapper.toPatient(patientRequest, id);
        patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
    }
}
