package com.wincentzzz.project.template.springhack.repositories;

import com.wincentzzz.project.template.springhack.models.AppointmentMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentMedicineRepository extends JpaRepository<AppointmentMedicine, Long> {
}
