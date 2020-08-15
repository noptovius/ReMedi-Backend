package com.wincentzzz.project.template.springhack.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDetailResponse {
    private Long id;
    private String doctorName;
    private String hospitalName;
    private String date;
    private List<AppointmentDetailSymptom> symptoms;
    private List<AppointmentDetailDiagnosis> diagnosis;
//    private List<AppointmentDetailMedicine> medicines;
//    private List<AppointmentDetailExamination> examinations;
}
