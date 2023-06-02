package com.springboot.demo.week3.controller;

import com.springboot.demo.week3.dto.CreateUserDto;
import com.springboot.demo.week3.dto.ResponseCreateUser;
import com.springboot.demo.week3.dto.ResponseListUser;
import com.springboot.demo.week3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @GetMapping("/get-list-user")
  public ResponseEntity<ResponseListUser> getListUser() {
    return ResponseEntity.ok(userService.getListUser());
  }

  @PostMapping("/create-user")
  public ResponseEntity<ResponseCreateUser> createUser(@RequestBody CreateUserDto createUserDto) {
    return ResponseEntity.ok(userService.createUser(createUserDto));
  }
}
