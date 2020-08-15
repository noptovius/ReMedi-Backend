package com.wincentzzz.project.template.springhack.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorListResponse {
    private Long id;
    private String name;
    private String photo;
    private String location;
    private Float rating;
}
