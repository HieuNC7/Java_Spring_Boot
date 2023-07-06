package com.springboot.demo.week45.api.domain.user.delete;

import com.springboot.demo.week45.api.domain.user.service.Delete;
import com.springboot.demo.week45.core.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserDeleteService implements Delete<UserDeleteResponse> {

  private final UserRepository userRepository;

  @Override
  public UserDeleteResponse deleteAllById(List<Long> ids) {
    return UserDeleteResponse.of(userRepository.deleteAllById(ids));
  }

  @Override
  public UserDeleteResponse deleteById(long id) {
    return UserDeleteResponse.of(userRepository.deleteById(id));
  }
}
