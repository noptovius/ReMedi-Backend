package com.wincentzzz.project.template.springhack.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequest {
    private Long patientId;
    private Long doctorId;
    private Long hospitalId;
    private Date date;
    private List<AppointmentSymptom> symptoms;
    private List<AppointmentDiagnosis> diagnoses;
//    private String medicines;
    private Boolean isFinished;
    private Boolean isPaired;
    private String heartRate;
    private String bloodPressure;
    private String temperature;
}
