package com.springboot.demo.week45.api.domain.user.service;

import java.util.List;

public interface Delete<T> {

  T deleteAllById(List<Long> ids);

  T deleteById(long id);
}
