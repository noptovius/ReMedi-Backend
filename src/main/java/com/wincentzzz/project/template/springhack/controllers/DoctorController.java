package com.wincentzzz.project.template.springhack.controllers;

import com.wincentzzz.project.template.springhack.dto.request.DoctorRequest;
import com.wincentzzz.project.template.springhack.dto.request.PatientRequest;
import com.wincentzzz.project.template.springhack.dto.response.*;
import com.wincentzzz.project.template.springhack.mapper.DoctorMapper;
import com.wincentzzz.project.template.springhack.mapper.PatientMapper;
import com.wincentzzz.project.template.springhack.models.Doctor;
import com.wincentzzz.project.template.springhack.models.Patient;
import com.wincentzzz.project.template.springhack.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public BaseResponse<List<DoctorListResponse>> getAllDoctors(@RequestParam("pageNumber") Integer pageNumber,
                                                  @RequestParam(value = "doctorName", required = false, defaultValue = "%") String doctorName,
                                                  @RequestParam(value = "specialization", required = false, defaultValue = "%") String specialization){
        Page<Doctor> doctorPage = doctorService.getAllDoctors(doctorName, specialization, pageNumber);
        List<Doctor> doctors = doctorPage.getContent();
        return BaseResponse.<List<DoctorListResponse>>builder()
                .code(200)
                .pageResponse(PageResponse.builder()
                        .pageNumber(pageNumber)
                        .pageSize(doctorPage.getSize())
                        .totalPage(doctorPage.getTotalPages())
                        .build())
                .data(DoctorMapper.toDoctorlistResponse(doctors))
                .build();
    }

    @GetMapping("/{id}")
    public PatientResponse getDoctor(@PathVariable Long id){
        return DoctorMapper.toDoctorResponse(doctorService.getDoctor(id));
    }

    @PostMapping
    public void addDoctor(@RequestBody DoctorRequest doctorRequest){
        Doctor patient = DoctorMapper.toDoctor(doctorRequest);
        doctorService.addDoctor(patient);
    }

    @PutMapping("/{id}")
    public void updateDoctor(@PathVariable Long id, @RequestBody DoctorRequest doctorRequest){
        Doctor doctor = DoctorMapper.toDoctor(doctorRequest);
        doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
    }
}
