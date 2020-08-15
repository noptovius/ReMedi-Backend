package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.request.PatientRequest;
import com.wincentzzz.project.template.springhack.dto.response.PatientListResponse;
import com.wincentzzz.project.template.springhack.dto.response.PatientResponse;
import com.wincentzzz.project.template.springhack.models.Patient;
import com.wincentzzz.project.template.springhack.util.DateFormatter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PatientMapper {

    public static List<PatientListResponse> toListOfPatientResponse(List<Patient> patients){
        return patients.stream().map(patient -> PatientListResponse.builder()
                .id(patient.getId())
                .nik(patient.getNik())
                .name(patient.getName())
                .photo(patient.getPhoto())
                .dob(patient.getDob())
                .allergy(patient.getAllergy())
                .phoneNumber(patient.getPhoneNumber())
                .email(patient.getEmail())
                .build())
                .collect(Collectors.toList());
    }

    public static PatientResponse toPatientResponse(Patient patient){
        return PatientResponse.builder()
                .id(patient.getId())
                .nik(patient.getNik())
                .name(patient.getName())
                .photo(patient.getPhoto())
                .dob(DateFormatter.toDateString(patient.getDob()))
                .allergy(patient.getAllergy())
                .phoneNumber(patient.getPhoneNumber())
                .email(patient.getEmail())
                .unlock(Optional.ofNullable(patient.getUnlock()).orElse(false))
                .build();
    }

    public static Patient toPatient(PatientRequest patientRequest){
        return Patient.builder()
                .nik(patientRequest.getNik())
                .name(patientRequest.getName())
                .photo(patientRequest.getPhoto())
                .dob(patientRequest.getDob())
                .allergy(patientRequest.getAllergy())
                .phoneNumber(patientRequest.getPhoneNumber())
                .email(patientRequest.getEmail())
                .build();
    }

    public static Patient toPatient(PatientRequest patientRequest, Long id){
        return Patient.builder()
                .nik(patientRequest.getNik())
                .name(patientRequest.getName())
                .photo(patientRequest.getPhoto())
                .dob(patientRequest.getDob())
                .allergy(patientRequest.getAllergy())
                .phoneNumber(patientRequest.getPhoneNumber())
                .email(patientRequest.getEmail())
                .id(id)
                .build();
    }
}
