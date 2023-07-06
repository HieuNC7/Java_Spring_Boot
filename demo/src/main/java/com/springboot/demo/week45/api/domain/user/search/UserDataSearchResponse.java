package com.springboot.demo.week45.api.domain.user.search;

import com.springboot.demo.week45.core.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDataSearchResponse {

  private long id;
  private String fullName;
  private String email;
  private String phoneNumber;
  private String address;

  public static UserDataSearchResponse of(User user) {
    return UserDataSearchResponse.builder()
        .id(user.getId())
        .fullName(user.getFullName())
        .email(user.getEmail())
        .phoneNumber(user.getPhoneNumber())
        .address(user.getAddress())
        .build();
  }
}
