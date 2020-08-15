package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.request.AppointmentSymptom;
import com.wincentzzz.project.template.springhack.dto.response.SymptomResponse;

import java.util.ArrayList;
import java.util.List;

public class SymptomMapper {
    private static final String symptomDelimiter = "@";
    private static final String symptomDetailDelimiter = "#";

    public static List<SymptomResponse> toAppointmentDetailSymptoms(String symptoms){
        List<SymptomResponse> symptomResponses = new ArrayList<>();
        final int symptomIdIndex = 0;
        final int symptomNameIndex = 1;

        if(symptoms == null || symptoms.isEmpty()){
            return symptomResponses;
        }
        
        String[] splitSymptoms = symptoms.split(symptomDelimiter);
        for (String splitSymptom: splitSymptoms) {

            String[] splitSymptomDetails = splitSymptom.split(symptomDetailDelimiter);

            symptomResponses.add(SymptomResponse.builder()
                    .id(Long.valueOf(splitSymptomDetails[symptomIdIndex]))
                    .name(splitSymptomDetails[symptomNameIndex])
                    .build());
        }

        return symptomResponses;
    }

    public static String toAppointmentSymptomString(List<AppointmentSymptom> appointmentSymptoms){
        List<String> appointmentSymptomStrings = new ArrayList<>();

        if(appointmentSymptoms == null){
            return "";
        }

        for(AppointmentSymptom appointmentSymptom : appointmentSymptoms){
            appointmentSymptomStrings.add(appointmentSymptom.getId() + symptomDetailDelimiter +
                    appointmentSymptom.getName());
        }

        return String.join(symptomDelimiter, appointmentSymptomStrings);
    }
}
