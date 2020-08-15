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
public class AppointmentResponse {
    private Long id;
    private Boolean isPaired;
    private String doctorName;
    private String doctorSpecialization;
    private String hospitalName;
    private String date;
    private List<SymptomResponse> symptoms;
    private List<DiagnosisResponse> diagnosis;
    private List<ExaminationListResponse> examinations;
    private List<MedicineListResponse> medicines;

}
