package com.example.springbootdemo.controller;

import com.example.springbootdemo.entities.SysUser;
import com.example.springbootdemo.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {

  @Resource
  private UserRepository userDao;

  @GetMapping("/user/{id}")
  @ResponseBody
  public String getUser(@PathVariable("id") String id){
    return userDao.getOne(id).toString();
  }

  @GetMapping("/user")
  @ResponseBody
  public String insertUser(SysUser sysUser){
    return userDao.save(sysUser).toString();
  }

}
