package com.fullstack.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.util.Date;
import java.util.StringTokenizer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Size(min = 2, message = "Employee Name should be at least 2 characters")
    private String empName;

    
    private String empAddress;

    private double empSalary;

    @Range(min = 1000000000, max = 9999999999L, message = "Employee Contact Number must be 10 digit")
    @Column(unique = true)
    private long empContactNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;

    @Column(unique = true)
    @Email(message = "Email ID Must be valid")
    private String empEmailId;

    @Size(min = 4, message = "Password should be at least 4 characters")
    private String empPassword;


}
