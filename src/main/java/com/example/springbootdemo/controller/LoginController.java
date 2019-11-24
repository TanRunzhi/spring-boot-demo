package com.example.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


  // @PostMapping(value = "/user/login")  等效于  @RequestMapping(value = "/user/login",method = RequestMethod.POST) 详情可点进PostMapping注解源码查看
  @PostMapping(value = "/user/login")
//  @RequestMapping(value = "/user/login",method = RequestMethod.POST)
  public String login(String userName, String password, HttpSession s){
    s.setAttribute("userName",userName);
    // 直接返回 dashboard 在页面刷新会被重复提交表单  这里要做重定向
    return "redirect:/main.html";
  }


  @RequestMapping(value = "/user/loginOut")
  public String loginOut(HttpSession s){
    s.invalidate();
    return "redirect:/login.html";
  }


  @GetMapping("/jspTest")
  public String index(Model model){
    model.addAttribute("name", "dalaoyang");
    return "index";
  }

}
