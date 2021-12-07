package com.example.workwithexceptions.service;

import java.util.List;

public interface EmployeeService {

    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    boolean findEmployee(String firstName, String lastName);

    List<Employee> printAllEmployees();

}
