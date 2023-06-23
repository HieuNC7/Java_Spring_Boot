package com.springboot.demo.week45.api.domain.user.service;

public interface Create<S, T> {
  T execute(S request);
}
