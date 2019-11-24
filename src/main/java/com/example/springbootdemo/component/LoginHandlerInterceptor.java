package com.example.springbootdemo.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    String userName = (String)request.getSession().getAttribute("userName");
    if(userName == null){

      request.getRequestDispatcher("/login.html").forward(request,response);
      return false;
    }else{
      //放行请求
      return true;
    }
  }

}
