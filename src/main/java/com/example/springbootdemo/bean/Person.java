package com.example.springbootdemo.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Data 注解在类上，会为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。
 * @ConfigurationProperties 告诉springboot将本类中的所有属性和配置文件中的相关配置进行绑定 ( 可用下方@Value代替 )
 *       prefix = "person" 配置文件下面的那个属性进行映射
 *       可配合 @Validated 对属性进行值的校验
 *@PropertySource 和@ConfigurationProperties一起用，读取其他配置文件下面的值
 * */
@Data
@Component
@ConfigurationProperties(prefix = "person")
//@PropertySource("classpath:person.properties")
@Validated
public class Person {
  /***
   * <bean class="">
   *   <property name="" value="字面量、${key}从环境变量或配置文件中读取值、#{spring表达式}"></property>
   * </bean>
   */
//  @Value("${person.last-name}")
//  @Email 校验是否为邮箱地址格式 和 @Validated 一起用
  private String lastName;
//  @Value("#{11*2}")
  private Integer age;
//  @Value("true")
  private Boolean boss;
  private Date birth;

  //  @Value("${person.maps}")  不支持复杂的类型封装
  private Map<String,Object> maps;
  private List<Object> lists;
  private Dog dog;


}
