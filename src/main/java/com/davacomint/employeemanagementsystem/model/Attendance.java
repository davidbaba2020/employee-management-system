package com.davacomint.employeemanagementsystem.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "attendace")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceID;

    @Column(name = "employee_id")
    private Long employeeID;

    @Column(name = "monday" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date attendanceMonday;

    @Column(name = "tuesday" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date attendanceTuesday;

    @Column(name = "wednesday" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date attendanceWednesday;

    @Column(name = "thursday" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date attendanceThursday;

    @Column(name = "friday" )
    @Temporal(TemporalType.TIMESTAMP)
    private Date attendanceFriday;

    @Column(name = "total_monthly_attendance")
    private Integer totalDaysPresentWeekly;
}
