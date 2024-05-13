package com.ra.springweb_jdbc.DAO.impl;

import com.ra.springweb_jdbc.DAO.IEmployeeDAO;
import com.ra.springweb_jdbc.model.Employee;
import com.ra.springweb_jdbc.utils.ConnectDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeIDaoImpl implements IEmployeeDAO {
    @Autowired
    private ConnectDB connectDB;

    @Override
    public List<Employee> findAll() {
        Connection con = connectDB.getConnection();
        List<Employee> list = new ArrayList<>();
        try {
            CallableStatement call = con.prepareCall("select * from employees");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Employee employee = Employee.builder()
                        .employeeId(rs.getInt("emp_id"))
                        .employeeName(rs.getString("emp_name"))
                        .gender(rs.getBoolean("gender"))
                        .birthDay(rs.getDate("birthday"))
                        .address(rs.getString("address"))
                        .department(rs.getString("department"))
                        .position(rs.getString("position"))
                        .salary(rs.getFloat("salary"))
                        .build();
                list.add(employee);

            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectDB.closeConnection(con);
        }

    }

    @Override
    public Employee findById(Integer id) {
        Connection con = connectDB.getConnection();
        Employee employee = null;
        try {
            CallableStatement call = con.prepareCall("select * from employees where emp_id =?");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            if (rs.next()) {
                employee = Employee.builder()
                        .employeeId(rs.getInt("emp_id"))
                        .employeeName(rs.getString("emp_name"))
                        .gender(rs.getBoolean("gender"))
                        .birthDay(rs.getDate("birthday"))
                        .address(rs.getString("address"))
                        .department(rs.getString("department"))
                        .position(rs.getString("position"))
                        .salary(rs.getFloat("salary"))
                        .build();

            }
            return employee;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectDB.closeConnection(con);
        }
    }

    @Override
    public void save(Employee employee) {
        Connection con = connectDB.getConnection();
        CallableStatement call = null;
        try {
            if (employee.getEmployeeId() == null) {
                //them moi
                call = con.prepareCall("insert into employees(emp_name,gender,birthday,address,department,position,salary) values (?,?,?,?,?,?,?)");

            } else {
                //sua
                call = con.prepareCall("update employees set emp_name=?,gender=?,birthday=?, address=?,department=?,position=?,salary=? where emp_id=?");
                call.setInt(8, employee.getEmployeeId());
            }
            call.setString(1, employee.getEmployeeName());
            call.setBoolean(2, employee.getGender());
            call.setDate(3, new java.sql.Date(employee.getBirthDay().getTime()));
            call.setString(4, employee.getAddress());
            call.setString(5, employee.getDepartment());
            call.setString(6, employee.getPosition());
            call.setFloat(7, employee.getSalary());
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectDB.closeConnection(con);
        }

    }

    @Override
    public void deleteById(Integer id) {
        Connection con = connectDB.getConnection();
        try {
            CallableStatement call = con.prepareCall("delete from employees where emp_id =?");
            call.setInt(1, id);
            call.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectDB.closeConnection(con);
        }

    }
}
