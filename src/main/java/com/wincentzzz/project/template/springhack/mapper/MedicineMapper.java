package com.wincentzzz.project.template.springhack.mapper;

import com.wincentzzz.project.template.springhack.dto.response.MedicineListResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedicineMapper {

    public static List<MedicineListResponse> getEmptyListOfMedicineResponse(){
        MedicineListResponse[] medicineListResponses = new MedicineListResponse[] {

        };

        return Arrays.asList(medicineListResponses);
    }

    public static List<MedicineListResponse> getDummyListOfMedicineResponse(){
        MedicineListResponse[] medicineListResponses = new MedicineListResponse[] {
                MedicineListResponse.builder().id((long) 1)
                    .name("Paracetamol")
                    .weight("50 mg").build(),
                MedicineListResponse.builder().id((long) 2)
                        .name("Paracetamol 2")
                        .weight("25 mg").build(),
        };

        return Arrays.asList(medicineListResponses);
    }
}
