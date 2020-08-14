package com.wincentzzz.project.template.springhack.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Builder
@Table(name = "doctor")
public class Doctor {

    @Id
    private Long id;

    @Column(name = "username")
    private String name;

    @Column(name = "photo")
    private String photo;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;
}
