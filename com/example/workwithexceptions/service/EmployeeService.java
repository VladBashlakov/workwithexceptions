package com.example.workwithexceptions.service;

import com.example.workwithexceptions.data.Employee;

import java.util.HashMap;

public interface EmployeeService {

    void removeEmployee(Integer id);

    Employee getEmployee(Integer id);

    void addEmployee(String firstName, String lastName);

    HashMap<Integer, Employee> printAllEmployees();

    boolean check(String str);


}
