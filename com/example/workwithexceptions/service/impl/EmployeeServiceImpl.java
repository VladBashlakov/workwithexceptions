package com.example.workwithexceptions.service.impl;

import com.example.workwithexceptions.data.Employee;
import com.example.workwithexceptions.exceptions.BadNameError;
import com.example.workwithexceptions.exceptions.EmployeeNotFoundException;
import com.example.workwithexceptions.service.DepartmentService;
import com.example.workwithexceptions.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService, DepartmentService {
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
    public boolean check(String str) {
        if (!StringUtils.isEmpty(str) && StringUtils.isAlpha(str)) {
            return true;
        } else {
            throw new BadNameError();
        }
    }

    @Override
    public void addEmployee(String firstName, String lastName) {

        if (check(firstName) && check(lastName))
            employees.put(getId(), new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName)));

    }

    @Override
    public HashMap<Integer, Employee> printAllEmployees() {
        return (HashMap<Integer, Employee>) employees;
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employees.values().stream()
                .filter(e -> e.isDepartment(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employees.values().stream()
                .filter(e -> e.isDepartment(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> getEmployeesFor(int department) {
        return employees.values().stream()
                .filter(e -> e.isDepartment(department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return employees.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}




