package com.wincentzzz.project.template.springhack.controllers;

import com.wincentzzz.project.template.springhack.dto.request.MedicineRequest;
import com.wincentzzz.project.template.springhack.dto.response.BaseResponse;
import com.wincentzzz.project.template.springhack.dto.response.MedicineListResponse;
import com.wincentzzz.project.template.springhack.dto.response.MedicineResponse;
import com.wincentzzz.project.template.springhack.dto.response.PageResponse;
import com.wincentzzz.project.template.springhack.mapper.MedicineMapper;
import com.wincentzzz.project.template.springhack.models.Medicine;
import com.wincentzzz.project.template.springhack.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medicines")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public BaseResponse<List<MedicineListResponse>> getAllMedicines(@RequestParam(value = "pageNumber", required =
            false, defaultValue = "0") Integer pageNumber){
        Page<Medicine> medicinePage = medicineService.getAllMedicines(pageNumber);
        List<Medicine> medicines = medicinePage.getContent();
        return BaseResponse.<List<MedicineListResponse>>builder()
                .code(200)
                .paging(PageResponse.builder()
                        .pageNumber(pageNumber)
                        .totalElements(medicinePage.getNumberOfElements())
                        .totalPage(medicinePage.getTotalPages())
                        .build())
                .data(MedicineMapper.toMedicinelistResponse(medicines))
                .build();
    }

    @GetMapping("/{id}")
    public BaseResponse<MedicineResponse> getMedicine(@PathVariable Long id){
        MedicineResponse medicine = MedicineMapper.toMedicineResponse(medicineService.getMedicine(id));
        return BaseResponse.<MedicineResponse>builder()
                .code(200)
                .data(medicine)
                .build();
    }

    @PostMapping
    public BaseResponse<Void> addMedicine(@RequestBody MedicineRequest medicineRequest){
        Medicine patient = MedicineMapper.toMedicine(medicineRequest);
        medicineService.addMedicine(patient);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> updateMedicine(@PathVariable Long id, @RequestBody MedicineRequest medicineRequest){
        Medicine medicine = MedicineMapper.toMedicine(medicineRequest);
        medicineService.updateMedicine(id, medicine);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteMedicine(@PathVariable Long id){
        medicineService.deleteMedicine(id);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }
}
