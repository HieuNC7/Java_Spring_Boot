package com.springboot.demo.week45.api.service;

public interface DeleteUser<S, T> {

  T deleteAllUsers();

  T deleteUser(S request);
}
