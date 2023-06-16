package com.springboot.demo.week45.api.domain.user.search;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserSearchController {

  private final UserSearchService userSearchService;

  @GetMapping
  public ResponseEntity<List<UserSearchResponse>> searchAll() {
    return ResponseEntity.ok(userSearchService.findAllUser());
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserSearchResponse> search(@PathVariable long userId) {
    return ResponseEntity.ok(
        userSearchService.findUser(UserSearchRequest.builder().id(userId).build()));
  }
}
