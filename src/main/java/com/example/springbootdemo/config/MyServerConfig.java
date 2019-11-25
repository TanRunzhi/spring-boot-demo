package com.example.springbootdemo.config;

import com.example.springbootdemo.filter.MyFilter;
import com.example.springbootdemo.servlet.MyServlet;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import java.util.Arrays;

@Configuration
public class MyServerConfig {

  /**
   * 定制嵌入式的servlet容器相关规则
   * */
  @Bean
  public WebServerFactoryCustomizer webServerFactoryCustomizer(){
    return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
      @Override
      public void customize(ConfigurableServletWebServerFactory factory) {
        ((TomcatServletWebServerFactory)factory).addConnectorCustomizers(new TomcatConnectorCustomizer() {
          @Override
          public void customize(Connector connector) {
//            connector.setPort(8082);
          }
        });
      }
    };
  }

  @Bean
  public ServletRegistrationBean myServlet(){
    //自定义Servlet的配置  第一个参数  哪个Servlet 后面字符串  哪些请求进入这里面
    return new ServletRegistrationBean<>(new MyServlet(),"/myServlet");
  }

  @Bean
  public FilterRegistrationBean myFilter(){
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    registrationBean.setFilter(new MyFilter());
    registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
    return registrationBean;
  }

//  @Bean
  public ServletListenerRegistrationBean myListener(){
    // 原理同上
    return null;
  }

  /**
   * SpringMVC自动配置的前端控制器在
   * {@link org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration}
   */

}
