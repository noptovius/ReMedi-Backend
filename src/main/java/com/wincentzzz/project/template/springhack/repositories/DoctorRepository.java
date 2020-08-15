package com.wincentzzz.project.template.springhack.repositories;

import com.wincentzzz.project.template.springhack.models.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findDoctorsByNameLikeAndSpecializationLike(String name, String specialization, Pageable pageable);
}
