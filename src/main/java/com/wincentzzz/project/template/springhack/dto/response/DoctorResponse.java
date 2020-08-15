package com.wincentzzz.project.template.springhack.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResponse {
    private Long id;
    private String name;
    private String photo;
    private Date dob;
    private String phoneNumber;
    private String email;
    private String location;
    private Float rating;
    private String specialization;
    private Integer totalAppointments;
}
