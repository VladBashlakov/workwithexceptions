package com.example.workwithexceptions.controller;


import com.example.workwithexceptions.data.Employee;
import com.example.workwithexceptions.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/employee")
@RestController
public class FirstController {
    private final EmployeeService employeeService;

    public FirstController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String showAdd(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.addEmployee(firstName, lastName);
        return " сотрудник " + firstName + " " + lastName + " успешно создан";
    }

    @GetMapping("/remove")
    public String showRemove(@RequestParam Integer id) {
        employeeService.removeEmployee(id);
        return "сотрудник ID " + id + " успешно удален";
    }

    @GetMapping("/find")
    public String showFind(@RequestParam Integer id) {
        employeeService.getEmployee(id);
        return "сотрудник " + employeeService.getEmployee(id) + " успешно найден";
    }

    @GetMapping("/printAll")
    public Map<Integer, Employee> printAll() {
        return employeeService.printAllEmployees();
    }
}

