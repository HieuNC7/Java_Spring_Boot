package com.springboot.demo.week3.service.impl;

import com.springboot.demo.week3.dto.CreateUserDto;
import com.springboot.demo.week3.entity.User;
import com.springboot.demo.week3.repository.UserRepository;
import com.springboot.demo.week3.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public List<User> getListUser() {
    return userRepository.findAllUser();
  }

  @Override
  public Long createUser(CreateUserDto userDto) {
    return userRepository.createUser(userDto);
  }
}
