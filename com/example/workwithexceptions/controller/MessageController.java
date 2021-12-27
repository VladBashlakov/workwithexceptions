package com.example.workwithexceptions.controller;

import com.example.workwithexceptions.service.MessagesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/employee")
@RestController
public class MessageController {
    private final MessagesService messagesService;

    public MessageController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @GetMapping("/addEmp")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        messagesService.check(firstName + lastName);
        return " сотрудник " + StringUtils.capitalize(firstName) + " " + lastName + " успешно создан";

    }
}
