package com.ra.springweb_jdbc.service;

import com.ra.springweb_jdbc.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(Integer id);
    void save(Employee employee);
    void deleteById(Integer id);
}
