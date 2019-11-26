package com.example.springbootdemo.config;

import com.example.springbootdemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Configuration 指定当前类是个配置类
 *   代替以前的配置的xml ( 详见启动器的 @ImportResource(locations = {"classpath:beans.xml"}) )
 */
@Configuration
public class MyAppConfig {

  /**
   * @Bean 同xml中的<bean></bean>配置
   * 方法签名 同<bean id="" class=""></bean>的id
   *     如 此处是helloService 这注入时候就以这个为准
   * @return 被注入完成的类 类名同<bean id="" class=""></bean>的class
   */
  @Bean
  public HelloService helloService(){
    System.out.println("sys.out.prt - in com.example.springbootdemo.config.MyAppConfig.helloService ");
    return new HelloService();
  }



}
