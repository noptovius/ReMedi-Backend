package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.response.PageResponse;
import org.springframework.data.domain.Page;

public class PageMapper {
    public static PageResponse toPageResponse(Page page){
        return PageResponse.builder()
                .pageNumber(page.getNumber())
                .totalElements(page.getNumberOfElements())
                .totalPage(page.getTotalPages()).build();
    }
}
