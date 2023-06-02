package com.springboot.demo.week3.dto;

import com.springboot.demo.week3.entity.User;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListUser {
  private int total;
  private List<User> data;
}
