package com.springboot.demo.week1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class firstController {
    @GetMapping("/")
    public String firstRestApi(){
        return "Hello World!";
    }
}
