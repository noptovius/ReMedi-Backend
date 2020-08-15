package com.wincentzzz.project.template.springhack.controllers;

import com.wincentzzz.project.template.springhack.dto.request.ExaminationRequest;
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
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;

    @GetMapping
    public List<ExaminationListResponse> getAllExaminations(){
        return ExaminationMapper.toListOfExaminationResponse(examinationService.getAllExaminations());
    }

    @GetMapping("/{id}")
    public ExaminationResponse getExamination(@PathVariable Long id){
        return ExaminationMapper.toExaminationResponse(examinationService.getExamination(id));
    }

    @PostMapping
    public void addExamination(@RequestBody ExaminationRequest examinationRequest){
        Examination examination = ExaminationMapper.toExamination(examinationRequest);
        examinationService.addExamination(examination);
    }

    @PutMapping("/{id}")
    public void updateExamination(@PathVariable Long id, @RequestBody ExaminationRequest examinationRequest){
        Examination examination = ExaminationMapper.toExamination(examinationRequest, id);
        examinationService.updateExamination(id, examination);
    }

    @DeleteMapping("/{id}")
    public void deleteExamination(@PathVariable Long id) {
        examinationService.deleteExamination(id);
    }
}
