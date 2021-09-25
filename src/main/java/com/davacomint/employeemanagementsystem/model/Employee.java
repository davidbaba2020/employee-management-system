package com.davacomint.employeemanagementsystem.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_table")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeID;

    @Column(name = "first_name")
    private String employeeFirstName;

    @Column(name = "last_name")
    private String employeeLastName;

    @Column(name = "email", unique=true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "rank")
    @Enumerated(EnumType.STRING)
    private Rank staffType;
}
