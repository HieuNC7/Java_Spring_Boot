package com.springboot.demo.week3.service;

import com.springboot.demo.week3.dto.CreateUserDto;
import com.springboot.demo.week3.dto.ResponseCreateUser;
import com.springboot.demo.week3.dto.ResponseListUser;

public interface UserService {

  ResponseListUser getListUser();

  ResponseCreateUser createUser(CreateUserDto userDto);
}
