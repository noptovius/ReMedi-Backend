package com.wincentzzz.project.template.springhack.services;

import com.wincentzzz.project.template.springhack.models.Medicine;
import org.springframework.data.domain.Page;

public interface MedicineService {
    Page<Medicine> getAllMedicines(Integer pageNumber);
    Medicine getMedicine(Long id);
    void addMedicine(Medicine patient);
    void updateMedicine(Long id, Medicine medicine);
    void deleteMedicine(Long id);
}
