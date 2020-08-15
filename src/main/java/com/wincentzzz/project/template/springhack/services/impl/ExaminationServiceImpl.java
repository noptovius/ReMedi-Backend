package com.wincentzzz.project.template.springhack.services.impl;

import com.wincentzzz.project.template.springhack.models.Examination;
import com.wincentzzz.project.template.springhack.repositories.ExaminationRepository;
import com.wincentzzz.project.template.springhack.services.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;

    @Override
    public List<Examination> getAllExaminations() {
        return examinationRepository.findAll();
    }

    @Override
    public Examination getExamination(Long id) {
        return examinationRepository.findById(id).get();
    }

    @Override
    public void addExamination(Examination examination) {
        examinationRepository.save(examination);
    }

    @Override
    public void updateExamination(Long id, Examination examination) {
        examinationRepository.save(examination);
    }

    @Override
    public void deleteExamination(Long id) {
        examinationRepository.deleteById(id);
    }
}
