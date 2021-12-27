package com.example.workwithexceptions.service.impl;

import com.example.workwithexceptions.exceptions.BadNameError;
import com.example.workwithexceptions.service.MessagesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class MessagesServiceImpl implements MessagesService {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Override
    public void check(String str) {
        if (!StringUtils.isEmpty(str) && StringUtils.isAlpha(str)) {
            employeeService.addEmployee(StringUtils.capitalize(StringUtils.substringBefore(str, " ")), StringUtils.substringAfter(str, " "));
        } else {
            throw new BadNameError();
        }
    }
}
