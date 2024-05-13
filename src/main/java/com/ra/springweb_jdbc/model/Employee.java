package com.ra.springweb_jdbc.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Employee {
    private Integer employeeId;
    private String employeeName;
    private Boolean gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;
    private String address;
    private String department;
    private String position;
    private Float salary;

}
