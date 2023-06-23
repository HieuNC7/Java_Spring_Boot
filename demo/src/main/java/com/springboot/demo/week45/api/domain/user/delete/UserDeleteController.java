package com.springboot.demo.week45.api.domain.user.delete;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserDeleteController {

  private final UserDeleteService userDeleteService;

  @DeleteMapping
  public ResponseEntity<UserDeleteResponse> deleteAllById(@RequestBody List<Long> userIds) {
    return ResponseEntity.ok(userDeleteService.deleteAllById(userIds));
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<UserDeleteResponse> deleteById(@PathVariable long userId) {
    return ResponseEntity.ok(userDeleteService.deleteById(userId));
  }
}
