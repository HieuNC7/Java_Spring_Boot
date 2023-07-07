package com.springboot.demo.week45.core.repository;

import com.springboot.demo.week45.api.domain.user.search.UserSearchRequest;
import com.springboot.demo.week45.core.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface UserRepository {

  Long create(User user);

  Long update(User user);

  List<User> list(UserSearchRequest request, RowBounds rowBounds);

  User findById(long id);

  Long deleteAllById(List<Long> ids);

  Long deleteById(long id);
}
