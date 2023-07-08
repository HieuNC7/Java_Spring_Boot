package com.springboot.demo.week45.util;

public class Constant {
  private Constant(){
    throw new IllegalStateException("Utility class");
  }
  // rowBounds default value
  public static final int DEFAULT_OFFSET = 0;
  public static final int DEFAULT_LIMIT = 10;
}