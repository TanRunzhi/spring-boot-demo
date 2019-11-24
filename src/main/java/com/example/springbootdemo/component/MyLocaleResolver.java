package com.example.springbootdemo.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 可以在链接上面携带区域信息
 * {@link org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter#localeResolver() }
 * */
public class MyLocaleResolver implements LocaleResolver {
  @Override
  public Locale resolveLocale(HttpServletRequest request) {
    String lanuage = request.getParameter("l");
    Locale locale ;
    if(!StringUtils.isEmpty(lanuage)){
      String[] l = lanuage.split("_");
      locale = new Locale(l[0],l[1]);
    }else{
      //系统默认的
//      locale = Locale.getDefault();
      // 请求头默认的
      locale = request.getLocale();
    }
    return locale;
  }

  @Override
  public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

  }
}
