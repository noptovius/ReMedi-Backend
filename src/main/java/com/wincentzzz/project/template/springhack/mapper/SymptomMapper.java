package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.request.AppointmentSymptom;
import com.wincentzzz.project.template.springhack.dto.response.AppointmentDetailSymptom;

import java.util.ArrayList;
import java.util.List;

public class SymptomMapper {
    private static final String symptomDelimiter = "@";
    private static final String symptomDetailDelimiter = "#";

    public static List<AppointmentDetailSymptom> toAppointmentDetailSymptoms(String symptoms){
        List<AppointmentDetailSymptom> appointmentDetailSymptoms = new ArrayList<>();

        final int symptomIdIndex = 0;
        final int symptomNameIndex = 1;
        
        String[] splitSymptoms = symptoms.split(symptomDelimiter);
        for (String splitSymptom: splitSymptoms) {

            String[] splitSymptomDetails = splitSymptom.split(symptomDetailDelimiter);

            appointmentDetailSymptoms.add(AppointmentDetailSymptom.builder()
                    .id(Long.valueOf(splitSymptomDetails[symptomIdIndex]))
                    .name(splitSymptomDetails[symptomNameIndex])
                    .build());
        }

        return appointmentDetailSymptoms;
    }

    public static String toAppointmentSymptomString(List<AppointmentSymptom> appointmentSymptoms){
        List<String> appointmentSymptomStrings = new ArrayList<>();

        for(AppointmentSymptom appointmentSymptom : appointmentSymptoms){
            appointmentSymptomStrings.add(appointmentSymptom.getId() + symptomDetailDelimiter +
                    appointmentSymptom.getName());
        }

        return String.join(symptomDelimiter, appointmentSymptomStrings);
    }
}
