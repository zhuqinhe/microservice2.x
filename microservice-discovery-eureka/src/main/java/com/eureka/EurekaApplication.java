package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



/**
 * eureka 注册server 后续需要考虑高可用
 * 暂不开启安全认证   
 * 端口规划  默认8761
 * @Description 
 * @author hoob
 * @date 2020年5月12日上午11:09:17
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekaApplication.class, args);
  }
  
  @EnableWebSecurity
  public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
      @Override
      protected void configure(HttpSecurity http) throws Exception {
          super.configure(http);//加这句是为了访问eureka控制台和/actuator时能做安全控制
          http.csrf().disable();//关闭csrf
      }
  }

}
