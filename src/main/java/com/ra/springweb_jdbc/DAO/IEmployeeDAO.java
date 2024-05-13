package com.ra.springweb_jdbc.DAO;

import com.ra.springweb_jdbc.model.Employee;


import java.util.List;

public interface IEmployeeDAO {
    List<Employee> findAll();
    Employee findById(Integer id);
    void save(Employee employee);
    void deleteById(Integer id);
}
