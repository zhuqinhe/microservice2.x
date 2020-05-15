package com.bookmark;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/** 书签微服务
 *  6690
 * @Description 
 * @author hoob
 * @date 2020年5月12日下午4:10:01
 */

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceBookmarkApplication {

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(MicroserviceBookmarkApplication.class, args);
  }
}
