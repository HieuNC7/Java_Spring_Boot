package com.springboot.demo.week45.api.domain.user.update;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserUpdateController {

  private final UserUpdateService userUpdateService;

  @PutMapping("/{userId}")
  public ResponseEntity<UserUpdateResponse> update(
      @PathVariable long userId, @RequestBody UserUpdateRequest request) {
    request.setId(userId);
    return ResponseEntity.ok(userUpdateService.execute(request));
  }
}
