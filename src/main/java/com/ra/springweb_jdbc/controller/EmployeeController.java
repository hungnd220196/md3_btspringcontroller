package com.ra.springweb_jdbc.controller;

import com.ra.springweb_jdbc.DAO.IEmployeeDAO;
import com.ra.springweb_jdbc.DAO.impl.EmployeeIDaoImpl;
import com.ra.springweb_jdbc.model.Employee;
import com.ra.springweb_jdbc.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("employees", employeeService.findById(id));
        return "edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        employeeService.deleteById(id);
        return "redirect:/list";
    }

    @PostMapping("/add") // xử lý form thêm mới
    public String doAdd(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/list";
    }

    @PostMapping("/update") // xử lý form sửa
    public String doUpdate(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/list";
    }

}
