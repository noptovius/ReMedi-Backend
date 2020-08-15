package com.wincentzzz.project.template.springhack.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentFinishingRequest {
    private Boolean isFinished;
    private String heartRate;
    private String bloodPressure;
    private String temperature;
    private List<AppointmentSymptom> symptoms;
    private List<AppointmentDiagnosis> diagnoses;
}
