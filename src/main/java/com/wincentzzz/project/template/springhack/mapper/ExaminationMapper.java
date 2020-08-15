package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.request.ExaminationRequest;
import com.wincentzzz.project.template.springhack.dto.response.ExaminationListResponse;
import com.wincentzzz.project.template.springhack.dto.response.ExaminationResponse;
import com.wincentzzz.project.template.springhack.models.Appointment;
import com.wincentzzz.project.template.springhack.models.Examination;

import java.util.List;
import java.util.stream.Collectors;

public class ExaminationMapper {

    public static List<ExaminationListResponse> toListOfExaminationResponse(List<Examination> examinations){
        return examinations.stream().map(examination -> ExaminationListResponse.builder()
                .id(examination.getId())
                .name(examination.getName())
                .file(examination.getFile())
                .build()
        ).collect(Collectors.toList());
    }

    public static ExaminationResponse toExaminationResponse(Examination examination){
        return ExaminationResponse.builder()
                .id(examination.getId())
                .name(examination.getName())
                .file(examination.getFile())
                .build();
    }

    public static Examination toExamination(ExaminationRequest examinationRequest){
        return Examination.builder()
                .name(examinationRequest.getName())
                .file(examinationRequest.getFile())
                .appointment(Appointment.builder().id(examinationRequest.getAppointmentId()).build())
                .build();
    }

    public static Examination toExamination(ExaminationRequest examinationRequest, Long id){
        return Examination.builder()
                .name(examinationRequest.getName())
                .file(examinationRequest.getFile())
                .appointment(Appointment.builder().id(examinationRequest.getAppointmentId()).build())
                .id(id)
                .build();
    }
}
