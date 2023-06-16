package com.springboot.demo.week45.api.domain.user.create;

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
public class UserCreateRequest {

  private String fullName;
  private String email;
  private String phoneNumber;
  private String address;

  public User.UserBuilder toUserBuilder() {
    return User.builder()
        .fullName(this.fullName)
        .email(this.email)
        .phoneNumber(this.phoneNumber)
        .address(this.address);
  }
}
