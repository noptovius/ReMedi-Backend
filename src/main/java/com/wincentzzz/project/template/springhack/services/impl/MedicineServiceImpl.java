package com.wincentzzz.project.template.springhack.services.impl;

import com.wincentzzz.project.template.springhack.models.Medicine;
import com.wincentzzz.project.template.springhack.repositories.MedicineRepository;
import com.wincentzzz.project.template.springhack.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    private final Integer SIZE = 10;

    @Override
    public Page<Medicine> getAllMedicines(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, SIZE);
        return medicineRepository.findAll(pageable);
    }

    @Override
    public Medicine getMedicine(Long id) {
        return medicineRepository.getOne(id);
    }

    @Override
    public void addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    @Override
    public void updateMedicine(Long id, Medicine medicine) {
        medicine.setId(id);
        medicineRepository.save(medicine);
    }

    @Override
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }
}
