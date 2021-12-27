package com.example.workwithexceptions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class BadNameError extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "$$$$$$ BAD NAME $$$$$$";

    public BadNameError() {
        super(DEFAULT_MESSAGE);
    }
}
