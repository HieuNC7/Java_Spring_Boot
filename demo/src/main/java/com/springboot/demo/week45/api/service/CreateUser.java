package com.springboot.demo.week45.api.service;

public interface CreateUser<S, T> {
  T execute(S request);
}
