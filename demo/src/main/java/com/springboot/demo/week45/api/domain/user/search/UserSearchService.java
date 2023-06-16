package com.springboot.demo.week45.api.domain.user.search;

import com.springboot.demo.week45.api.service.SearchUser;
import com.springboot.demo.week45.core.entity.User;
import com.springboot.demo.week45.core.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserSearchService implements SearchUser<UserSearchRequest, UserSearchResponse> {

  private final UserRepository userRepository;

  @Override
  public List<UserSearchResponse> findAllUser() {
    List<User> userList = userRepository.findAllUser();
    return userList.stream().map(UserSearchResponse::of).collect(Collectors.toList());
  }

  @Override
  public UserSearchResponse findUser(UserSearchRequest request) {
    User user = userRepository.findUser(request.getId());
    return UserSearchResponse.of(user);
  }
}
