package com.wincentzzz.project.template.springhack.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExaminationResponse {
    private Long id;
    private String name;
    private String file;
}
