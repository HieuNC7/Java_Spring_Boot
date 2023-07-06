package com.springboot.demo.week45.api.domain.user.create;

import com.springboot.demo.week45.api.domain.user.service.Create;
import com.springboot.demo.week45.core.entity.User;
import com.springboot.demo.week45.core.repository.UserRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserCreateService implements Create<UserCreateRequest, UserCreateResponse> {

  private final UserRepository userRepository;

  @Override
  public UserCreateResponse execute(UserCreateRequest request) {
    User user = request.toUserBuilder().createdAt(LocalDateTime.now()).createdBy("HieuNC7").build();
    userRepository.create(user);
    return UserCreateResponse.of(user);
  }
}
