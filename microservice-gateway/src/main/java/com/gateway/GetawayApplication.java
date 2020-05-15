package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableEurekaClient
public class GetawayApplication {
  public static void main(String[] args) {
    SpringApplication.run(GetawayApplication.class, args);
  }
  //在配置里面配置
  // @Bean
  public RouteLocator myRoutes(RouteLocatorBuilder builder) {
      return builder.routes()
              .route("path-route",p -> p
                      //断言为“/get”，凡是访问路由网关中的“/get”路径
                      .path("/get")
                      //在请求头中增加“Hello”—“World”键值对
                      .filters(f -> f.addRequestHeader("Hello", "World"))
                      //转发到http://httpbin.org
                      .uri("http://httpbin.org"))
              //使用hystrix
              .route("hystrix-route",p -> p
                      //当请求头中的Host为*.hystrix.com，进入此路由
                      .host("*.hystrix.com")
                      //设置Hystrix熔断，当请求（转发到http://httpbin.org）超时时，请求转发到Gateway中的“/fallback”
                      .filters(f -> f.hystrix(
                              config -> config.setName("cmd").setFallbackUri("forward:/fallback")))
                      //转发到http://httpbin.org
                      .uri("http://httpbin.org"))
              .build();
  }
}
