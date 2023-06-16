package com.springboot.demo.week45.api.domain.user.delete;

import com.springboot.demo.week45.api.service.DeleteUser;
import com.springboot.demo.week45.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserDeleteService implements DeleteUser<UserDeleteRequest, UserDeleteResponse> {

  private final UserRepository userRepository;

  @Override
  public UserDeleteResponse deleteAllUsers() {
    return UserDeleteResponse.of(userRepository.deleteAllUsers());
  }

  @Override
  public UserDeleteResponse deleteUser(UserDeleteRequest request) {
    return UserDeleteResponse.of(userRepository.deleteUser(request.getId()));
  }
}
