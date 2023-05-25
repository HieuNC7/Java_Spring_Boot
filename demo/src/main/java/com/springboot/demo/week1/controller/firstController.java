package com.springboot.demo.week1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restApi")
public class firstController {
    @GetMapping("/firstApi")
    public String firstRestApi(){
        return "Hello World!";
    }
}
