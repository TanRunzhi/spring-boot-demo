package com.example.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyExceptionController {

  /**
   * 括号里面填一个异常的class或继承了异常的自定义异常的class
   * */
//  @ExceptionHandler(RuntimeException.class)
//  @ResponseBody
//  public Map<String,Object> handleException(Exception e){
//    Map<String,Object> map = new HashMap<>();
//    map.put("code","自定义json数据的信息");
//    return map;
//  }

  @ExceptionHandler(RuntimeException.class)
  public String handleException(Exception e, HttpServletRequest request){
    //
    request.setAttribute("javax.servlet.error.status_code",400);
    //
    Map<String,Object> map = new HashMap<>();
    map.put("code","自定义json数据的信息");
    return "forward:/error";
  }

}
