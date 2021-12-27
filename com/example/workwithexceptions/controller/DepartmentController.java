package com.example.workwithexceptions.controller;


import com.example.workwithexceptions.data.Employee;
import com.example.workwithexceptions.service.DepartmentService;
import com.example.workwithexceptions.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    public Employee getEmpWithMinSalaryByDepartment(@RequestParam int department) {
        return departmentService.getEmployeeWithMinSalary(department);
    }

    @GetMapping("/max-salary")
    public Employee getEmpWithMaxSalaryByDepartment(@RequestParam int department) {
        return departmentService.getEmployeeWithMaxSalary(department);
    }

    @GetMapping("all")
    Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return departmentService.getAllEmployeesByDepartment();
    }
}
