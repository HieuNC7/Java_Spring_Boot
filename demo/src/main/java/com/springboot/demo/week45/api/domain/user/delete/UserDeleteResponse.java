package com.springboot.demo.week45.api.domain.user.delete;

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
public class UserDeleteResponse {

  private long total;

  public static UserDeleteResponse of(long total){
    return UserDeleteResponse.builder().total(total).build();
  }
}
