package com.springboot.demo.week45.api.domain.user.create;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserCreateController {

  private final UserCreateService userCreateService;

  @PostMapping
  public ResponseEntity<UserCreateResponse> create(@RequestBody UserCreateRequest request) {
    return ResponseEntity.ok(userCreateService.execute(request));
  }
}
