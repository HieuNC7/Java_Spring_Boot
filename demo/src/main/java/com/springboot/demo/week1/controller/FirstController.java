package com.springboot.demo.week1.controller;

import com.springboot.demo.week1.dto.HelloWorldDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restApi")
public class FirstController {

  @GetMapping("/firstApi")
  public HelloWorldDto firstRestApi() {
    return new HelloWorldDto("Hello World!");
  }
}
