package com.wincentzzz.project.template.springhack.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
