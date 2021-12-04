package com.example.workwithexceptions.service;

public interface EmployeeService {

    void addEmployee(String firstName, String lastName) ;

    void removeEmployee(String firstName, String lastName);

    void findEmployee(String firstName, String lastName);
}
