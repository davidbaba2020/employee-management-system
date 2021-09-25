package com.davacomint.employeemanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryID;

    @Column(name = "amount_payeable")
    private Double amout;

    @Column(name = "attendanceTotal")
    private Integer attendanceTotal;

    @Column(name = "bonus")
    private Double bonus;
}
