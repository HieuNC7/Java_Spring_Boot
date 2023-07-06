package com.springboot.demo.week45.api.domain.user.service;

public interface Update<S, T> {
  T execute(S request);
}
