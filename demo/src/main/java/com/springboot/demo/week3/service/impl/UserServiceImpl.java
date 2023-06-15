package com.springboot.demo.week3.service.impl;

import com.springboot.demo.week3.dto.CreateUserDto;
import com.springboot.demo.week3.dto.ResponseCreateUser;
import com.springboot.demo.week3.dto.ResponseListUser;
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
  public ResponseListUser getListUser() {
    ResponseListUser res = new ResponseListUser();
    List<User> listUser = userRepository.findAllUser();
    res.setData(listUser);
    res.setTotal(listUser.size());
    return res;
  }

  @Override
  public ResponseCreateUser createUser(CreateUserDto userDto) {
    ResponseCreateUser res = new ResponseCreateUser();
    Long resCreate = userRepository.createUser(userDto);
    if (resCreate >= 1) {
      res.setMessage("Create user - Success");
    } else {
      res.setMessage("Create user - Fail");
    }
    return res;
  }
}
