package com.example.kiemtra.controller;

import com.example.kiemtra.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping({"/", "/employees"})
    public String showEmployeeList(Model model) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Nguyễn Tiến Thành", "Dev", 12000.0));
        employees.add(new Employee(2, "Trần Anh Dũng", "Tester", 8000.0));
        employees.add(new Employee(3, "Bàng Trọng Tú", "Dev", 15000.0));
        employees.add(new Employee(3, "Nguyễn Trần Bảo Khánh", "Dev", 6000.0));

        model.addAttribute("employeeList", employees);

        return "employee-list";
    }
}