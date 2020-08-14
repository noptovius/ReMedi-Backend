package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.request.HospitalRequest;
import com.wincentzzz.project.template.springhack.dto.response.HospitalListResponse;
import com.wincentzzz.project.template.springhack.dto.response.HospitalResponse;
import com.wincentzzz.project.template.springhack.models.Hospital;

import java.util.List;
import java.util.stream.Collectors;

public class HospitalMapper {

    public static List<HospitalListResponse> toListOfHospitalResponse(List<Hospital> hospitals){
        return hospitals.stream().map(hospital -> HospitalListResponse.builder()
            .name(hospital.getName())
            .address(hospital.getAddress())
            .city(hospital.getCity())
            .build())
            .collect(Collectors.toList());
    }

    public static HospitalResponse toHospitalResponse(Hospital hospital){
        return HospitalResponse.builder()
                .name(hospital.getName())
                .address(hospital.getAddress())
                .city(hospital.getCity())
                .build();
    }

    public static Hospital toHospital(HospitalRequest hospitalRequest){
        return Hospital.builder()
                .name(hospitalRequest.getName())
                .address(hospitalRequest.getAddress())
                .city(hospitalRequest.getCity())
                .build();
    }

    public static Hospital toHospital(HospitalRequest hospitalRequest, Long id){
        return Hospital.builder()
                .name(hospitalRequest.getName())
                .address(hospitalRequest.getAddress())
                .city(hospitalRequest.getCity())
                .id(id)
                .build();
    }
}
