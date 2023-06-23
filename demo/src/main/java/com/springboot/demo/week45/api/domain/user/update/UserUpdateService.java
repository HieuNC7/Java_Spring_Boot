package com.springboot.demo.week45.api.domain.user.update;

import com.springboot.demo.week45.api.service.UpdateUser;
import com.springboot.demo.week45.core.entity.User;
import com.springboot.demo.week45.core.repository.UserRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserUpdateService implements UpdateUser<UserUpdateRequest, UserUpdateResponse> {

  private final UserRepository userRepository;

  @Override
  public UserUpdateResponse execute(UserUpdateRequest request) {
    User user =
        request
            .toUserBuilder()
            .id(request.getId())
            .updatedAt(LocalDateTime.now())
            .updatedBy("HieuNC7")
            .build();
    userRepository.updateUser(user);
    return UserUpdateResponse.of(user);
  }
}
