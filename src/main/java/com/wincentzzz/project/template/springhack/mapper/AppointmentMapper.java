package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.request.AppointmentFinishingRequest;
import com.wincentzzz.project.template.springhack.dto.request.AppointmentPairingRequest;
import com.wincentzzz.project.template.springhack.dto.request.AppointmentRequest;
import com.wincentzzz.project.template.springhack.dto.response.*;
import com.wincentzzz.project.template.springhack.models.*;
import com.wincentzzz.project.template.springhack.util.DateFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.wincentzzz.project.template.springhack.util.DateFormatter.getMonth;

public class AppointmentMapper {

    public static AppointmentListResponse toAllAppointmentsListResponse(List<Appointment> appointments){

        List<AppointmentListGroup> appointmentListGroups = new ArrayList<>();
        Integer currentMonth = 0;
        List<String> months = new ArrayList<String>(Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OKT", "NOV", "DEC"));
        for(Integer i = 0 ; i < appointments.size() ; i++) {
            Appointment appointment = appointments.get(i);
            Integer month = getMonth(appointment.getDate());
            if(!currentMonth.equals(month)) {
                currentMonth = month;
                AppointmentListGroup appointmentListGroup = AppointmentListGroup.builder()
                        .month(months.get(currentMonth - 1))
                        .appointmentListItems(new ArrayList<>())
                        .build();
                appointmentListGroups.add(appointmentListGroup);
            }

            AppointmentListGroup appointmentListGroup = appointmentListGroups.get(appointmentListGroups.size() - 1);
            AppointmentListItem appointmentListitem = AppointmentListItem.builder()
                    .id(appointment.getId())
                    .isPaired(appointment.getIsPaired())
                    .date(DateFormatter.toDateString(appointment.getDate()))
                    .doctorName(appointment.getDoctor().getName())
                    .doctorSpecialization(appointment.getDoctor().getSpecialization())
                    .hospitalName(appointment.getHospital().getName())
                    .build();
            appointmentListGroup.getAppointmentListItems().add(appointmentListitem);

        }

        return AppointmentListResponse.builder()
                .appointmentListGroups(appointmentListGroups)
                .build();
    }

    public static AppointmentListResponse toAppointmentListResponse(List<Appointment> appointments){
        Appointment latestAppointment = appointments.get(0);
        List<AppointmentListGroup> appointmentListGroups = new ArrayList<>();

        Integer currentMonth = 0;

        List<String> months = new ArrayList<String>(Arrays.asList("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OKT", "NOV", "DEC"));

        for(Integer i = 0 ; i < appointments.size() ; i++) {
            Appointment appointment = appointments.get(i);
            Integer month = getMonth(appointment.getDate());
            if(!currentMonth.equals(month)) {
                currentMonth = month;
                AppointmentListGroup appointmentListGroup = AppointmentListGroup.builder()
                        .month(months.get(currentMonth - 1))
                        .appointmentListItems(new ArrayList<>())
                        .build();
                appointmentListGroups.add(appointmentListGroup);
            }

            AppointmentListGroup appointmentListGroup = appointmentListGroups.get(appointmentListGroups.size() - 1);
            AppointmentListItem appointmentListitem = AppointmentListItem.builder()
                    .id(appointment.getId())
                    .isPaired(appointment.getIsPaired())
                    .date(DateFormatter.toDateString(appointment.getDate()))
                    .doctorName(appointment.getDoctor().getName())
                    .doctorSpecialization(appointment.getDoctor().getSpecialization())
                    .hospitalName(appointment.getHospital().getName())
                    .build();
            appointmentListGroup.getAppointmentListItems().add(appointmentListitem);

        }

        return AppointmentListResponse.builder()
                .bloodPressure(latestAppointment.getBloodPressure())
                .heartRate(latestAppointment.getHeartRate())
                .temperature(latestAppointment.getTemperature())
                .appointmentListGroups(appointmentListGroups)
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
