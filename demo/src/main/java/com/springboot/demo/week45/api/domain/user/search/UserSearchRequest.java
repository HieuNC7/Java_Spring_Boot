package com.springboot.demo.week45.api.domain.user.search;

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
public class UserSearchRequest {

  private long id;
  private String fullName;
  private String email;
  private String phoneNumber;
  private String address;
  private int limit;
  private int offset;

  public UserSearchRequest(String email) {
    this.email = email;
  }
}
