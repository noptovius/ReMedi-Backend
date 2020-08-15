package com.wincentzzz.project.template.springhack.controllers;

import com.wincentzzz.project.template.springhack.dto.request.AppointmentRequest;
import com.wincentzzz.project.template.springhack.dto.response.*;
import com.wincentzzz.project.template.springhack.mapper.AppointmentMapper;
import com.wincentzzz.project.template.springhack.models.Appointment;
import com.wincentzzz.project.template.springhack.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/appointment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppointmentController {

    private static final int itemsPerPage = 10;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public BaseResponse<AppointmentListResponse> getAllAppointments() {
        return BaseResponse.<AppointmentListResponse>builder()
                .code(200)
                .data(AppointmentMapper.toAllAppointmentsListResponse(appointmentService.getAllAppointments()))
                .build();
    }

    @GetMapping("/patient/{patientId}")
    public BaseResponse<AppointmentListResponse>
    getScheduledAppointmentsByPatientId(@PathVariable Long patientId,
                                        @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, itemsPerPage, Sort.by("date").descending());
        Page<Appointment> appointmentPage = appointmentService.getScheduledAppointmentsByPatientId(patientId, pageable);
        List<Appointment> appointments = appointmentPage.getContent();

        PageResponse pageResponse = PageResponse.builder()
                .pageNumber(appointmentPage.getNumber())
                .totalElements(appointmentPage.getNumberOfElements())
                .totalPage(appointmentPage.getTotalPages()).build();

        return BaseResponse.<AppointmentListResponse>builder()
                .code(200)
                .paging(pageResponse)
                .data(AppointmentMapper.toAppointmentListResponse(appointments))
                .build();
    }

    @GetMapping("/patient/{patientId}/record")
    public BaseResponse<AppointmentListResponse>
    getFinishedAppointmentsByPatientId(@PathVariable Long patientId,
                                       @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, itemsPerPage, Sort.by("date").descending());
        Page<Appointment> appointmentPage = appointmentService.getFinishedAppointmentsByPatientId(patientId, pageable);
        List<Appointment> appointments = appointmentPage.getContent();

        PageResponse pageResponse = PageResponse.builder()
                .pageNumber(appointmentPage.getNumber())
                .totalElements(appointmentPage.getNumberOfElements())
                .totalPage(appointmentPage.getTotalPages()).build();

        return BaseResponse.<AppointmentListResponse>builder()
                .code(200)
                .paging(pageResponse)
                .data(AppointmentMapper.toAppointmentListResponse(appointments))
                .build();
    }


    @GetMapping("/{id}")
    public BaseResponse<AppointmentResponse> getAppointment(@PathVariable Long id) {
        return BaseResponse.<AppointmentResponse>builder()
                .code(200)
                .data(AppointmentMapper.toAppointmentDetailResponse(appointmentService.getAppointment(id)))
                .build();
    }

    @PostMapping
    public BaseResponse<Void> addAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        Appointment appointment = AppointmentMapper.toAppointment(appointmentRequest);
        appointmentService.addAppointment(appointment);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> updateAppointment(@PathVariable Long id,
                                             @RequestBody AppointmentRequest appointmentRequest) {
        Appointment appointment = AppointmentMapper.toAppointment(appointmentRequest, id);
        appointmentService.updateAppointment(id, appointment);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }



    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @PutMapping("/{id}/pairing")
    public BaseResponse<Void> updateAppointmentPairing(@PathVariable Long id,
                                                       @RequestBody Boolean isPaired){
        Appointment appointment = appointmentService.getAppointment(id);
        appointment.setIsPaired(isPaired);
        appointmentService.updateAppointment(id, appointment);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }

    @PutMapping("/{id}/record")
    public BaseResponse<Void> updateAppointmentToFinished(@PathVariable Long id,
                                                      @RequestBody AppointmentRequest appointmentRequest){
        Appointment appointment = appointmentService.getAppointment(id);
        appointmentService.updateAppointment(id, appointment);

        return BaseResponse.<Void>builder()
                .code(200)
                .build();
    }
}
