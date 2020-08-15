package com.wincentzzz.project.template.springhack.controllers;

import com.wincentzzz.project.template.springhack.dto.request.HospitalRequest;
import com.wincentzzz.project.template.springhack.dto.response.BaseResponse;
import com.wincentzzz.project.template.springhack.dto.response.HospitalListResponse;
import com.wincentzzz.project.template.springhack.dto.response.HospitalResponse;
import com.wincentzzz.project.template.springhack.mapper.HospitalMapper;
import com.wincentzzz.project.template.springhack.models.Hospital;
import com.wincentzzz.project.template.springhack.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hospital")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping
    public BaseResponse<List<HospitalListResponse>> getAllHospitals(){
        return BaseResponse.<List<HospitalListResponse>>builder()
                .code(200)
                .data(HospitalMapper.toListOfHospitalResponse(hospitalService.getAllHospitals()))
                .build();

    }

    @GetMapping("/{id}")
    public BaseResponse<HospitalResponse> getHospital(@PathVariable Long id){
        return BaseResponse.<HospitalResponse>builder()
                .code(200)
                .data(HospitalMapper.toHospitalResponse(hospitalService.getHospital(id)))
                .build();
    }

    @PostMapping
    public BaseResponse<Void> addHospital(@RequestBody HospitalRequest hospitalRequest){
        Hospital hospital = HospitalMapper.toHospital(hospitalRequest);
        hospitalService.addHospital(hospital);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> updateHospital(@PathVariable Long id, @RequestBody HospitalRequest hospitalRequest){
        Hospital hospital = HospitalMapper.toHospital(hospitalRequest, id);
        hospitalService.updateHospital(id, hospital);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteHospital(@PathVariable Long id) {
        hospitalService.deleteHospital(id);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }
}
