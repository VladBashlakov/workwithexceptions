package com.example.workwithexceptions.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(String firstName, String lastName) {
        employees.add(new Employee(firstName, lastName));
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (findEmployee(firstName, lastName)) {
            employees.remove(employee);
        }
    }

    @Override
    public boolean findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return true;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public List<Employee> printAllEmployees() {
        return employees;
    }
}




