package com.example.springbootdemo.config;

import com.example.springbootdemo.component.LoginHandlerInterceptor;
import com.example.springbootdemo.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
/***
 * @EnableWebMvc 完全接管SpringMvc的配置  不要springboot的默认配置了
 */
//@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    //浏览器发送/atguigu请求  来到success页面
    registry.addViewController("/atguigu").setViewName("success");
  }

  // 由于所有的WebMvcConfiguerAdapter组建都会起作用
  @Bean
  public WebMvcConfigurer webMvcConfigurerAdapter(){
    new WebMvcConfigurationSupport();
     return new WebMvcConfigurer(){
       /***
        * 添加默认视图映射的配置
        * @param registry
        */
       @Override
       public void addViewControllers(ViewControllerRegistry registry) {
         registry.addViewController("/").setViewName("login");
         registry.addViewController("/index.html").setViewName("login");
         registry.addViewController("/login.html").setViewName("login");
         // 这里设置登录的重定向
         registry.addViewController("/main.html").setViewName("dashboard");
       }

       /***
        * 添加拦截器的配置
        * @param registry
        */
       @Override
       public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(new LoginHandlerInterceptor())
             // "/**"  任意多层路径下的任意请求
             .addPathPatterns("/**")
             //排除上面的请求外的请求
             .excludePathPatterns("/","/index.html","/login.html","/user/login")
             // 排除相关静态资源的映射
             .excludePathPatterns("/favicon.ico")
             .excludePathPatterns("/webjars/**","/asserts/**");

       }
     };
  }

  /***
   *  解析链接上面携带区域信息
   * {@link org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter#localeResolver() }
   */
  @Bean
  public LocaleResolver localeResolver(){
    return new MyLocaleResolver();
  }


}
