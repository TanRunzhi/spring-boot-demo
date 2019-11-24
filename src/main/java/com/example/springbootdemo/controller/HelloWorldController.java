package com.example.springbootdemo.controller;

import com.example.springbootdemo.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloWorldController {

//  在MyMvcConifg中已经配置了  这里就注释了
//  @RequestMapping({"/","/index.html"})
//  public String index(){
//    return "index";
//  }

  /***
   *  ------  分隔线 --------------
   */
  @Autowired
  Person p;
  @Value("${person.last-name}")
  String name;


  @RequestMapping("/hello")
  @ResponseBody
  public String hello(){
    return name + " hello " + p.toString();
  }

  @RequestMapping("/success")
//  @ResponseBody  不加这行会直接看返回的字符串来找页面
  public String success(Map<String,Object> map){
    map.put("hello"," a string data ");
    // classpath:/templates/success.html
    return "success";
  }
}
