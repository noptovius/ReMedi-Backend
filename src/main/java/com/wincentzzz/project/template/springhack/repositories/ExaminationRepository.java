package com.wincentzzz.project.template.springhack.repositories;

import com.wincentzzz.project.template.springhack.models.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {
}
