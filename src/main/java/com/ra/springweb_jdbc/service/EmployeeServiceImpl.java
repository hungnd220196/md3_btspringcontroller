package com.ra.springweb_jdbc.service;

import com.ra.springweb_jdbc.DAO.IEmployeeDAO;
import com.ra.springweb_jdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeDAO iEmployeeDAO;

    @Override
    public List<Employee> findAll() {
        return iEmployeeDAO.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeDAO.findById(id);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeDAO.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        iEmployeeDAO.deleteById(id);
    }
}
