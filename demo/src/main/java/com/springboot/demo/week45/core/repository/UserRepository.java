package com.springboot.demo.week45.core.repository;

import com.springboot.demo.week45.core.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

  Long createUser(User user);

  Long updateUser(User user);

  List<User> findAllUser();

  User findUser(long id);

  Long deleteAllUsers();

  Long deleteUser(long id);
}
