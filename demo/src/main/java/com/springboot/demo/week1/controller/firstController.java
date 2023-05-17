package com.springboot.demo.week1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest-api")
public class firstController {
    @GetMapping("/first-api")
    public String firstRestApi(){
        return "Hello World!";
    }
}
