package com.wincentzzz.project.template.springhack.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentListItem {
    private Long id;
    private Boolean isPaired;
    private String doctorName;
    private String doctorSpecialization;
    private String hospitalName;
    private String date;
}
