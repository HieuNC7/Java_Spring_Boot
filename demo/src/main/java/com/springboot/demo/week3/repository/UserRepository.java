package com.springboot.demo.week3.repository;

import com.springboot.demo.week3.dto.CreateUserDto;
import com.springboot.demo.week3.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

  List<User> findAllUser();

  Long createUser(CreateUserDto createUserDto);
}
