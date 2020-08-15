package com.wincentzzz.project.template.springhack.services;

import com.wincentzzz.project.template.springhack.models.Examination;

import java.util.List;

public interface ExaminationService {
    List<Examination> getAllExaminations();
    Examination getExamination(Long id);
    void addExamination(Examination examination);
    void updateExamination(Long id, Examination examination);
    void deleteExamination(Long id);
}
