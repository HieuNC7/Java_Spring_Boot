package com.springboot.demo.week45.api.domain.user.search;

import com.springboot.demo.week45.api.domain.user.service.Search;
import com.springboot.demo.week45.core.entity.User;
import com.springboot.demo.week45.core.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserSearchService implements Search<UserSearchRequest, UserSearchResponse> {

  private final UserRepository userRepository;

  @Override
  public UserSearchResponse list(UserSearchRequest request) {
    RowBounds rowBounds = new RowBounds(request.getOffset(), request.getLimit());
    List<User> userList = userRepository.list(request, rowBounds);
    return UserSearchResponse.of(userList.stream().map(UserDataSearchResponse::of).toList());
  }

  @Override
  public UserSearchResponse findById(UserSearchRequest request) {
    User user = userRepository.findById(request.getId());
    List<UserDataSearchResponse> listData =
        Collections.singletonList(UserDataSearchResponse.of(user));
    return UserSearchResponse.of(listData);
  }
}
