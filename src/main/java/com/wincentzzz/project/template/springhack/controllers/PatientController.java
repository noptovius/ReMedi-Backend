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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public BaseResponse<List<PatientListResponse>> getAllPatients(){
        return BaseResponse.<List<PatientListResponse>> builder()
                .code(200)
                .data(PatientMapper.toListOfPatientResponse(patientService.getAllPatients()))
                .build();
    }

    @GetMapping("/{id}")
    public BaseResponse<PatientResponse> getPatient(@PathVariable Long id){
        return BaseResponse.<PatientResponse> builder()
                .code(200)
                .data(PatientMapper.toPatientResponse(patientService.getPatient(id)))
                .build();
    }

    @PostMapping
    public BaseResponse<Void> addPatient(@RequestBody PatientRequest patientRequest){
        Patient patient = PatientMapper.toPatient(patientRequest);
        patientService.addPatient(patient);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> updatePatient(@PathVariable Long id, @RequestBody PatientRequest patientRequest){
        Patient patient = PatientMapper.toPatient(patientRequest, id);
        patientService.updatePatient(id, patient);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Void> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @PatchMapping("/{id}/unlock")
    public BaseResponse<Void> unlockPatient(@PathVariable Long id, @RequestBody PatientRequest patientRequest){
        Patient patient = PatientMapper.toPatient(patientRequest, id);
        patientService.updatePatient(id, patient);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }
}
