package com.springboot.demo.week45.api.domain.user.search;

import java.util.List;
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
public class UserSearchResponse {

  private long total;
  private List<UserDataSearchResponse> data;

  public static UserSearchResponse of(List<UserDataSearchResponse> list) {
    return UserSearchResponse.builder().total(list.size()).data(list).build();
  }
}
