package com.example.workwithexceptions.controller;

import com.example.workwithexceptions.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String showRemove(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.removeEmployee(firstName, lastName);
        return "сотрудник " + firstName + " " + lastName + " успешно удален";
    }

    @GetMapping("/find")
    public String showFind(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.findEmployee(firstName, lastName);
        return "сотрудник " + firstName + " " + lastName + " успешно найден";
    }
}

