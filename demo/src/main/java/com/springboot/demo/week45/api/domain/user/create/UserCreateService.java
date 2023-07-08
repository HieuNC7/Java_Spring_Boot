package com.springboot.demo.week45.api.domain.user.create;

import com.springboot.demo.week45.api.domain.user.search.UserSearchRequest;
import com.springboot.demo.week45.api.domain.user.service.Create;
import com.springboot.demo.week45.core.entity.User;
import com.springboot.demo.week45.core.repository.UserRepository;
import com.springboot.demo.week45.util.Constant;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserCreateService implements Create<UserCreateRequest, UserCreateResponse> {

  private final UserRepository userRepository;

  @Override
  public UserCreateResponse execute(UserCreateRequest request) {
    // check exist user in db
    long checkExist =
        userRepository
            .list(
                new UserSearchRequest(request.getEmail()),
                new RowBounds(Constant.DEFAULT_OFFSET, Constant.DEFAULT_LIMIT))
            .size();
    if (checkExist == 0) {
      User user =
          request.toUserBuilder().createdAt(LocalDateTime.now()).createdBy("HieuNC7").build();
      userRepository.create(user);
      return UserCreateResponse.of(user);
    }
    return new UserCreateResponse();
  }
}
