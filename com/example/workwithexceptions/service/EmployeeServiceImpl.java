package com.example.workwithexceptions.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Employee[] employees = new Employee[10];

    @Override
    public void addEmployee(String firstName, String lastName) throws ArrayIndexOutOfBoundsException {
        for (int i = 0; i < 15; i++) {
            if (i > employees.length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, lastName);
                return;
            }
        }
    }


    @Override
    public void removeEmployee(String firstName, String lastName) throws NullPointerException {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                throw new NullPointerException();
            }
            if (employees[i] != null && employees[i].equals(new Employee(firstName, lastName))) {
                employees[i] = null;
                return;
            }
        }
    }


    @Override
    public void findEmployee(String firstName, String lastName) throws NullPointerException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                throw new NullPointerException();
            }
            if (employees[i] != null && employees[i].equals(new Employee(firstName, lastName))) {
                return;
            }
        }
    }
}

