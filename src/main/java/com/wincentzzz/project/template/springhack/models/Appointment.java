package com.wincentzzz.project.template.springhack.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "appointment")
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Hospital hospital;

    @OneToMany
    private List<Examination> examinations;

    @Column(name="date")
    private Date date;

    @Column(name="symptoms")
    private String symptoms;

    @Column(name="diagnosis")
    private String diagnosis;

    @Column(name="drug_prescription")
    private String drugPrescription;

    @Column(name="is_finished")
    private Boolean isFinished;

    @Column(name="heart_rate")
    private String heartRate;

    @Column(name="blood_pressure")
    private String bloodPressure;

    @Column(name="temperature")
    private String temperature;
}
