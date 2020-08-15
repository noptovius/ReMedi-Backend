package com.wincentzzz.project.template.springhack.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentMedicineItem {
    private Long appointmentMedicineId;
    private Long medicineId;
    private String name;
    private String weight;
}
