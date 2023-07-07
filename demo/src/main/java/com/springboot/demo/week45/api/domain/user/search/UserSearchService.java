package com.springboot.demo.week45.api.domain.user.search;

import com.springboot.demo.week45.api.domain.user.create.UserCreateRequest;
import com.springboot.demo.week45.api.domain.user.create.UserCreateService;
import com.springboot.demo.week45.api.domain.user.service.Search;
import com.springboot.demo.week45.core.entity.User;
import com.springboot.demo.week45.core.repository.UserRepository;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserSearchService implements Search<UserSearchRequest, UserSearchResponse> {

  private final UserRepository userRepository;

  private final UserCreateService userCreateService;

  @Override
  public UserSearchResponse list(UserSearchRequest request) {
    // get login user
    DefaultOidcUser loginUser =
        (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    RowBounds rowBounds = new RowBounds(request.getOffset(), request.getLimit());

    // check exist user in db
    long checkExist =
        userRepository
            .list(UserSearchRequest.builder().email(loginUser.getEmail()).build(), rowBounds)
            .size();
    if (checkExist == 0) {
      // create user
      UserCreateRequest createRequest =
          UserCreateRequest.builder()
              .fullName(loginUser.getFullName())
              .email(loginUser.getEmail())
              .phoneNumber(loginUser.getAttribute("phone_number"))
              .address(loginUser.getAttribute("address"))
              .build();
      userCreateService.execute(createRequest);
    }

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
