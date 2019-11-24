package com.example.springbootdemo.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Dog {
  private String name;
  private Integer age;

  @Override
  public String toString() {
    return "Dog{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
