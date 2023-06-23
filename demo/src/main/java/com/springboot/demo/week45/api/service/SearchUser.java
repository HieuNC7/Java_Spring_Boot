package com.springboot.demo.week45.api.service;

import java.util.List;

public interface SearchUser<S, T> {
  List<T> findAllUser();

  T findUser(S request);
}
