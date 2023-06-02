package com.springboot.demo.week3.service;

import com.springboot.demo.week3.dto.CreateUserDto;
import com.springboot.demo.week3.entity.User;
import java.util.List;

public interface UserService {

  List<User> getListUser();

  Long createUser(CreateUserDto userDto);
}
