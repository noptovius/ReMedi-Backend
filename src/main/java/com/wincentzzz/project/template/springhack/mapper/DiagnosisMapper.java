package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.request.AppointmentDiagnosis;
import com.wincentzzz.project.template.springhack.dto.response.DiagnosisResponse;

import java.util.ArrayList;
import java.util.List;

public class DiagnosisMapper {
    private static final String diagnosisDelimiter = "@";
    private static final String diagnosisDetailDelimiter = "#";

    public static List<DiagnosisResponse> toAppointmentDetailDiagnoses(String diagnoses){
        List<DiagnosisResponse> appointmentDetailDiagnoses = new ArrayList<>();

        final int diagnosisIdIndex = 0;
        final int diagnosisNameIndex = 1;

        String[] splitDiagnoses = diagnoses.split(diagnosisDelimiter);
        for (String splitDiagnosis: splitDiagnoses) {

            String[] splitDiagnosisDetails = splitDiagnosis.split(diagnosisDetailDelimiter);

            appointmentDetailDiagnoses.add(DiagnosisResponse.builder()
                    .id(Long.valueOf(splitDiagnosisDetails[diagnosisIdIndex]))
                    .name(splitDiagnosisDetails[diagnosisNameIndex])
                    .build());
        }

        return appointmentDetailDiagnoses;
    }

    public static String toAppointmentDiagnosisString(List<AppointmentDiagnosis> appointmentDiagnoses){
        List<String> appointmentDiagnosisStrings = new ArrayList<>();

        for(AppointmentDiagnosis appointmentDiagnosis : appointmentDiagnoses){
            appointmentDiagnosisStrings.add(appointmentDiagnosis.getId() + diagnosisDetailDelimiter +
                    appointmentDiagnosis.getName());
        }

        return String.join(diagnosisDelimiter, appointmentDiagnosisStrings);
    }
}
