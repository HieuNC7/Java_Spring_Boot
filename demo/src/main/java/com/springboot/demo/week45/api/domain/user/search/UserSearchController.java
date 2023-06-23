package com.springboot.demo.week45.api.domain.user.search;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserSearchController {

  private final UserSearchService userSearchService;

  @GetMapping
  public ResponseEntity<UserSearchResponse> search(
      @RequestParam String name,
      @RequestParam String email,
      @RequestParam String phoneNumber,
      @RequestParam String address,
      @RequestParam(defaultValue = "0") long pageIndex,
      @RequestParam(defaultValue = "10") long pageSize) {
    return ResponseEntity.ok(
        userSearchService.list(
            UserSearchRequest.builder()
                .fullName(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .address(address)
                .limit(pageSize < 1 ? 10 : pageSize)
                .offset(pageIndex < 0 ? 0 : pageIndex)
                .build()));
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserSearchResponse> searchById(@PathVariable long userId) {
    return ResponseEntity.ok(
        userSearchService.findById(UserSearchRequest.builder().id(userId).build()));
  }
}
