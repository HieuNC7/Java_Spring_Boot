package com.springboot.demo.week45.api.domain.user.update;

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
public class UserUpdateResponse {

  private long id;
  private String fullName;
  private LocalDateTime updatedAt;
  private String updatedBy;

  public static UserUpdateResponse of(User user) {
    return UserUpdateResponse.builder()
        .id(user.getId())
        .fullName(user.getFullName())
        .updatedAt(user.getUpdatedAt())
        .updatedBy(user.getUpdatedBy())
        .build();
  }
}
