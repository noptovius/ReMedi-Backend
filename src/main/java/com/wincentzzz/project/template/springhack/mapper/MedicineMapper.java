package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.request.MedicineRequest;
import com.wincentzzz.project.template.springhack.dto.response.MedicineListResponse;
import com.wincentzzz.project.template.springhack.dto.response.MedicineResponse;
import com.wincentzzz.project.template.springhack.models.Medicine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MedicineMapper {

    public static List<MedicineListResponse> getEmptyListOfMedicineResponse(){
        MedicineListResponse[] medicineListResponses = new MedicineListResponse[] {

        };

        return Arrays.asList(medicineListResponses);
    }

    public static List<MedicineListResponse> toMedicinelistResponse(List<Medicine> medicines){
        return medicines.stream().map(medicine -> MedicineListResponse.builder()
                .id(medicine.getId())
                .name(medicine.getName())
                .build())
                .collect(Collectors.toList());
    }

    public static MedicineResponse toMedicineResponse(Medicine medicine){
        return MedicineResponse.builder()
                .id(medicine.getId())
                .name(medicine.getName())
                .build();
    }

    public static Medicine toMedicine(MedicineRequest medicineRequest){
        return Medicine.builder()
                .name(medicineRequest.getName())
                .build();
    }
}
