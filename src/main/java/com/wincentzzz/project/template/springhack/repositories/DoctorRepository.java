package com.wincentzzz.project.template.springhack.repositories;

import com.wincentzzz.project.template.springhack.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
