package com.wincentzzz.project.template.springhack.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

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
}
