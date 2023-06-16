package com.springboot.demo.week45.api.service;

public interface UpdateUser<S, T> {
  T execute(S request);
}
