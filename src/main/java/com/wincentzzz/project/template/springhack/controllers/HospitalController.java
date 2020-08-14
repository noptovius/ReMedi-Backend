package com.wincentzzz.project.template.springhack.controllers;

import com.wincentzzz.project.template.springhack.dto.request.HospitalRequest;
import com.wincentzzz.project.template.springhack.dto.request.PatientRequest;
import com.wincentzzz.project.template.springhack.dto.response.HospitalListResponse;
import com.wincentzzz.project.template.springhack.dto.response.HospitalResponse;
import com.wincentzzz.project.template.springhack.dto.response.PatientListResponse;
import com.wincentzzz.project.template.springhack.dto.response.PatientResponse;
import com.wincentzzz.project.template.springhack.mapper.HospitalMapper;
import com.wincentzzz.project.template.springhack.mapper.PatientMapper;
import com.wincentzzz.project.template.springhack.models.Hospital;
import com.wincentzzz.project.template.springhack.models.Patient;
import com.wincentzzz.project.template.springhack.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping
    public List<HospitalListResponse> getAllHospitals(){
        return HospitalMapper.toListOfHospitalResponse(hospitalService.getAllHospitals());
    }

    @GetMapping("/{id}")
    public HospitalResponse getHospital(@PathVariable Long id){
        return HospitalMapper.toHospitalResponse(hospitalService.getHospital(id));
    }

    @PostMapping
    public void addHospital(@RequestBody HospitalRequest hospitalRequest){
        Hospital hospital = HospitalMapper.toHospital(hospitalRequest);
        hospitalService.addHospital(hospital);
    }

    @PutMapping("/{id}")
    public void updateHospital(@PathVariable Long id, @RequestBody HospitalRequest hospitalRequest){
        Hospital hospital = HospitalMapper.toHospital(hospitalRequest, id);
        hospitalService.updateHospital(id, hospital);
    }

    @DeleteMapping("/{id}")
    public void deleteHospital(@PathVariable Long id) {
        hospitalService.deleteHospital(id);
    }
}
