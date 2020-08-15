package com.wincentzzz.project.template.springhack.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentListResponse {
    private String heartRate;
    private String bloodPressure;
    private String temperature;
    private List<AppointmentListItem> appointmentList;
}
