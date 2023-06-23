package com.springboot.demo.week45.api.domain.user.create;

import com.springboot.demo.week45.core.entity.User;
import java.time.LocalDateTime;
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
public class UserCreateResponse {

  private long id;
  private String fullName;
  private LocalDateTime createdAt;
  private String createdBy;

  public static UserCreateResponse of(User user) {
    return UserCreateResponse.builder()
        .id(user.getId())
        .fullName(user.getFullName())
        .createdAt(user.getCreatedAt())
        .createdBy(user.getCreatedBy())
        .build();
  }
}
