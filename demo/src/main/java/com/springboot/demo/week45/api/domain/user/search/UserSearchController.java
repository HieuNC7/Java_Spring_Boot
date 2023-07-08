package com.springboot.demo.week45.api.domain.user.search;

import com.springboot.demo.week45.api.domain.user.create.UserCreateRequest;
import com.springboot.demo.week45.api.domain.user.create.UserCreateService;
import com.springboot.demo.week45.util.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
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

  private final UserCreateService userCreateService;

  @GetMapping
  public ResponseEntity<UserSearchResponse> search(
      Authentication authentication,
      @RequestParam String name,
      @RequestParam String email,
      @RequestParam String phoneNumber,
      @RequestParam String address,
      @RequestParam(defaultValue = "0") int pageIndex,
      @RequestParam(defaultValue = "10") int pageSize) {
    // get login user
    DefaultOidcUser loginUser = (DefaultOidcUser) authentication.getPrincipal();
    // create user
    UserCreateRequest createRequest =
        UserCreateRequest.builder()
            .fullName(loginUser.getFullName())
            .email(loginUser.getEmail())
            .phoneNumber(loginUser.getAttribute("phone_number"))
            .address(loginUser.getAttribute("address"))
            .build();
    userCreateService.execute(createRequest);

    return ResponseEntity.ok(
        userSearchService.list(
            UserSearchRequest.builder()
                .fullName(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .address(address)
                .limit(pageSize < 1 ? Constant.DEFAULT_LIMIT : pageSize)
                .offset(pageIndex < 0 ? Constant.DEFAULT_OFFSET : pageIndex)
                .build()));
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserSearchResponse> searchById(@PathVariable long userId) {
    return ResponseEntity.ok(
        userSearchService.findById(UserSearchRequest.builder().id(userId).build()));
  }
}
