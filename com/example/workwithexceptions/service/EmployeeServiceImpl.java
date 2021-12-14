package com.example.workwithexceptions.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<Integer, Employee> employees;

    private Integer id = 0;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    private Integer getId() {
        Integer result = id;
        id = id + 1;
        return result;
    }

    @Override
    public void removeEmployee(Integer id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
        } else {
            throw new EmployeeNotFoundException();
        }
    }


    @Override
    public Employee getEmployee(Integer id) {
        if (employees.containsKey(id)) {
            return employees.get(id);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public void addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.put(getId(), employee);
    }

    @Override
    public HashMap<Integer, Employee> printAllEmployees() {
        return (HashMap<Integer, Employee>) employees;
    }


}




