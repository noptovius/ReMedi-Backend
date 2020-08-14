package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.request.DoctorRequest;
import com.wincentzzz.project.template.springhack.dto.response.DoctorListResponse;
import com.wincentzzz.project.template.springhack.dto.response.PatientResponse;
import com.wincentzzz.project.template.springhack.models.Doctor;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorMapper {

    public static List<DoctorListResponse> toDoctorlistResponse(List<Doctor> doctors){
        return doctors.stream().map(doctor -> DoctorListResponse.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .photo(doctor.getPhoto())
                .dob(doctor.getDob())
                .phoneNumber(doctor.getPhoneNumber())
                .email(doctor.getEmail())
                .build())
                .collect(Collectors.toList());
    }

    public static PatientResponse toDoctorResponse(Doctor doctor){
        return PatientResponse.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .photo(doctor.getPhoto())
                .dob(doctor.getDob())
                .phoneNumber(doctor.getPhoneNumber())
                .email(doctor.getEmail())
                .build();
    }

    public static Doctor toDoctor(DoctorRequest doctorRequest){
        return Doctor.builder()
                .name(doctorRequest.getName())
                .photo(doctorRequest.getPhoto())
                .dob(doctorRequest.getDob())
                .phoneNumber(doctorRequest.getPhoneNumber())
                .email(doctorRequest.getEmail())
                .build();
    }
}
