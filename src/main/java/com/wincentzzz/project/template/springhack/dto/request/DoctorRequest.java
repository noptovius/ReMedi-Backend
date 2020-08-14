package com.wincentzzz.project.template.springhack.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorRequest {
    private Long id;
    private String name;
    private String photo;
    private Date dob;
    private String phoneNumber;
    private String email;
}
