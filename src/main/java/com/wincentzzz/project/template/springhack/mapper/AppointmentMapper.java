package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.request.AppointmentFinishingRequest;
import com.wincentzzz.project.template.springhack.dto.request.AppointmentPairingRequest;
import com.wincentzzz.project.template.springhack.dto.request.AppointmentRequest;
import com.wincentzzz.project.template.springhack.dto.response.AppointmentResponse;
import com.wincentzzz.project.template.springhack.dto.response.AppointmentListItem;
import com.wincentzzz.project.template.springhack.dto.response.AppointmentListResponse;
import com.wincentzzz.project.template.springhack.dto.response.MedicineListResponse;
import com.wincentzzz.project.template.springhack.models.*;
import com.wincentzzz.project.template.springhack.util.DateFormatter;

import java.util.List;
import java.util.stream.Collectors;

public class AppointmentMapper {

    public static AppointmentListResponse toAllAppointmentsListResponse(List<Appointment> appointments){

        return AppointmentListResponse.builder()
                .appointmentList(appointments.stream()
                        .map(appointment -> AppointmentListItem.builder()
                                .id(appointment.getId())
                                .isPaired(appointment.getIsPaired())
                                .date(DateFormatter.toDateString(appointment.getDate()))
                                .doctorName(appointment.getDoctor().getName())
                                .doctorSpecialization(appointment.getDoctor().getSpecialization())
                                .hospitalName(appointment.getHospital().getName())
                                .build())
                        .collect(Collectors.toList()))
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
                                .isPaired(appointment.getIsPaired())
                                .date(DateFormatter.toDateString(appointment.getDate()))
                                .doctorName(appointment.getDoctor().getName())
                                .doctorSpecialization(appointment.getDoctor().getSpecialization())
                                .hospitalName(appointment.getHospital().getName())
                                .build()).collect(Collectors.toList()))
                .build();
    }

    public static AppointmentResponse toAppointmentDetailResponse(Appointment appointment){
        return AppointmentResponse.builder()
                .id(appointment.getId())
                .isPaired(appointment.getIsPaired())
                .isFinished(appointment.getIsFinished())
                .doctorName(appointment.getDoctor().getName())
                .doctorSpecialization(appointment.getDoctor().getSpecialization())
                .hospitalName(appointment.getHospital().getName())
                .date(DateFormatter.toDateString(appointment.getDate()))
                .symptoms(SymptomMapper.toAppointmentDetailSymptoms(appointment.getSymptoms()))
                .diagnosis(DiagnosisMapper.toAppointmentDetailDiagnoses(appointment.getDiagnosis()))
                .examinations(ExaminationMapper.toListOfExaminationResponse(appointment.getExaminations()))
                .medicines(MedicineMapper.getEmptyListOfMedicineResponse())
                .build();
    }

    public static Appointment toAppointment(AppointmentRequest appointmentRequest){
        return Appointment.builder()
                .patient(Patient.builder().id(appointmentRequest.getPatientId()).build())
                .doctor(Doctor.builder().id(appointmentRequest.getDoctorId()).build())
                .hospital(Hospital.builder().id(appointmentRequest.getHospitalId()).build())
                .date(appointmentRequest.getDate())
                .isPaired(false)
                .isFinished(false)
                .build();
    }

    public static Appointment toUpdatedAppointment(AppointmentRequest appointmentRequest, Appointment appointment){
        appointment.setPatient(Patient.builder().id(appointmentRequest.getPatientId()).build());
        appointment.setDoctor(Doctor.builder().id(appointmentRequest.getDoctorId()).build());
        appointment.setHospital(Hospital.builder().id(appointmentRequest.getHospitalId()).build());
        appointment.setDate(appointmentRequest.getDate());

        return appointment;
    }

    public static Appointment toFinishedAppointment(AppointmentFinishingRequest appointmentRequest, Appointment appointment){
        appointment.setIsFinished(appointmentRequest.getIsFinished());
        appointment.setBloodPressure(appointmentRequest.getBloodPressure());
        appointment.setHeartRate(appointmentRequest.getHeartRate());
        appointment.setTemperature(appointmentRequest.getTemperature());
        appointment.setDiagnosis(DiagnosisMapper.toAppointmentDiagnosisString(appointmentRequest.getDiagnoses()));
        appointment.setSymptoms(SymptomMapper.toAppointmentSymptomString(appointmentRequest.getSymptoms()));

        return appointment;
    }

    public static Appointment toPairedAppointment(AppointmentPairingRequest appointmentRequest,
                                                  Appointment appointment){
        appointment.setIsPaired(appointmentRequest.getIsPaired());

        return appointment;
    }
}
