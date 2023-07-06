package com.springboot.demo.week45.api.domain.user.service;

public interface Search<S, T> {
  T list(S request);

  T findById(S request);
}
