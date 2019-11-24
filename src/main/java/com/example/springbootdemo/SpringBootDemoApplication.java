package com.example.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

//@ImportResource(locations = {"classpath:beans.xml"}) //导入spring的其他的配置文件  但是不是springboot的推荐方式 详见com.example.springbootdemo.config.MyAppConfig
@SpringBootApplication
public class SpringBootDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDemoApplication.class, args);
  }

  /**
   * 添加视图解析器
   * @return
   */
  @Bean
  public ViewResolver myVewReolver(){
    return new MyViewResolver();
  }

  private static class MyViewResolver implements ViewResolver{
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
      return null;
    }
  }
}
