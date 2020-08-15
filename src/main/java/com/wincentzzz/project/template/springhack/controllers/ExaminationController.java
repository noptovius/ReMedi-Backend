package com.wincentzzz.project.template.springhack.controllers;

import com.wincentzzz.project.template.springhack.dto.request.ExaminationRequest;
import com.wincentzzz.project.template.springhack.dto.response.BaseResponse;
import com.wincentzzz.project.template.springhack.dto.response.ExaminationListResponse;
import com.wincentzzz.project.template.springhack.dto.response.ExaminationResponse;
import com.wincentzzz.project.template.springhack.mapper.ExaminationMapper;
import com.wincentzzz.project.template.springhack.models.Examination;
import com.wincentzzz.project.template.springhack.services.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/examination")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;

    @GetMapping
    public BaseResponse<List<ExaminationListResponse>> getAllExaminations(){
        return BaseResponse.<List<ExaminationListResponse>>builder()
                .code(200)
                .data(ExaminationMapper.toListOfExaminationResponse(examinationService.getAllExaminations()))
                .build();
    }

    @GetMapping("/{id}")
    public BaseResponse<ExaminationResponse> getExamination(@PathVariable Long id){
        return BaseResponse.<ExaminationResponse>builder()
                .code(200)
                .data(ExaminationMapper.toExaminationResponse(examinationService.getExamination(id)))
                .build();
    }

    @PostMapping
    public BaseResponse<Void> addExamination(@RequestBody ExaminationRequest examinationRequest){
        Examination examination = ExaminationMapper.toExamination(examinationRequest);
        examinationService.addExamination(examination);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> updateExamination(@PathVariable Long id,
                                              @RequestBody ExaminationRequest examinationRequest){
        Examination examination = ExaminationMapper.toExamination(examinationRequest, id);
        examinationService.updateExamination(id, examination);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteExamination(@PathVariable Long id) {
        examinationService.deleteExamination(id);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }
}
