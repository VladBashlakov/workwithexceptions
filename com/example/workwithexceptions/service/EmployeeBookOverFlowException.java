package com.example.workwithexceptions.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)

public class EmployeeBookOverFlowException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Array of employees is full";

    public EmployeeBookOverFlowException() {
        super(DEFAULT_MESSAGE);

    }
}
