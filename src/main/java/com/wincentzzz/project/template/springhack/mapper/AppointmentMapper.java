package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.request.AppointmentRequest;
import com.wincentzzz.project.template.springhack.dto.response.AppointmentDetailResponse;
import com.wincentzzz.project.template.springhack.dto.response.AppointmentListItem;
import com.wincentzzz.project.template.springhack.dto.response.AppointmentListResponse;
import com.wincentzzz.project.template.springhack.models.Appointment;
import com.wincentzzz.project.template.springhack.models.Doctor;
import com.wincentzzz.project.template.springhack.models.Hospital;
import com.wincentzzz.project.template.springhack.models.Patient;
import com.wincentzzz.project.template.springhack.util.DateFormatter;

import java.util.List;
import java.util.stream.Collectors;

public class AppointmentMapper {

    public static AppointmentListResponse toAllAppointmentsListResponse(List<Appointment> appointments){
        return AppointmentListResponse.builder()
                .appointmentList(appointments.stream()
                        .map(appointment -> AppointmentListItem.builder()
                                .id(appointment.getId())
                                .date(DateFormatter.toDateString(appointment.getDate()))
                                .doctorName(appointment.getDoctor().getName())
                                .hospitalName(appointment.getHospital().getName())
                                .build()).collect(Collectors.toList()))
                .build();
    }

    public static AppointmentListResponse toAppointmentListResponse(List<Appointment> appointments){
        Appointment latestAppointment = appointments.get(0);
        return AppointmentListResponse.builder()
                .bloodPressure(latestAppointment.getBloodPressure())
                .heartRate(latestAppointment.getHeartRate())
                .temperature(latestAppointment.getTemperature())
                .appointmentList(appointments.stream()
                        .map(appointment -> AppointmentListItem.builder()
                                .id(appointment.getId())
                                .date(DateFormatter.toDateString(appointment.getDate()))
                                .doctorName(appointment.getDoctor().getName())
                                .hospitalName(appointment.getHospital().getName())
                                .build()).collect(Collectors.toList()))
                .build();
    }

    public static AppointmentDetailResponse toAppointmentDetailResponse(Appointment appointment){
        return AppointmentDetailResponse.builder()
                .id(appointment.getId())
                .doctorName(appointment.getDoctor().getName())
                .hospitalName(appointment.getHospital().getName())
                .date(DateFormatter.toDateString(appointment.getDate()))
                .symptoms(SymptomMapper.toAppointmentDetailSymptoms(appointment.getSymptoms()))
                .diagnosis(DiagnosisMapper.toAppointmentDetailDiagnoses(appointment.getDiagnosis()))
                .build();
    }

    public static Appointment toAppointment(AppointmentRequest appointmentRequest){
        return Appointment.builder()
                .patient(Patient.builder().id(Long.valueOf(appointmentRequest.getPatientId())).build())
                .doctor(Doctor.builder().id(Long.valueOf(appointmentRequest.getDoctorId())).build())
                .hospital(Hospital.builder().id(Long.valueOf(appointmentRequest.getHospitalId())).build())
                .date(appointmentRequest.getDate())
                .symptoms(SymptomMapper.toAppointmentSymptomString(appointmentRequest.getSymptoms()))
                .diagnosis(DiagnosisMapper.toAppointmentDiagnosisString(appointmentRequest.getDiagnoses()))
                .isFinished(appointmentRequest.getIsFinished())
                .bloodPressure(appointmentRequest.getBloodPressure())
                .temperature(appointmentRequest.getTemperature())
                .heartRate(appointmentRequest.getHeartRate())
                .build();
    }

    public static Appointment toAppointment(AppointmentRequest appointmentRequest, Long id){
        return Appointment.builder()
                .id(id)
                .patient(Patient.builder().id(Long.valueOf(appointmentRequest.getPatientId())).build())
                .doctor(Doctor.builder().id(Long.valueOf(appointmentRequest.getDoctorId())).build())
                .hospital(Hospital.builder().id(Long.valueOf(appointmentRequest.getHospitalId())).build())
                .date(appointmentRequest.getDate())
                .symptoms(SymptomMapper.toAppointmentSymptomString(appointmentRequest.getSymptoms()))
                .diagnosis(DiagnosisMapper.toAppointmentDiagnosisString(appointmentRequest.getDiagnoses()))
                .isFinished(appointmentRequest.getIsFinished())
                .bloodPressure(appointmentRequest.getBloodPressure())
                .temperature(appointmentRequest.getTemperature())
                .heartRate(appointmentRequest.getHeartRate())
                .build();
    }
}
