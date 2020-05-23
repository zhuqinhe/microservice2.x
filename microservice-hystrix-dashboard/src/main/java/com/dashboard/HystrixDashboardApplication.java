package com.dashboard;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

/**
 * eureka 监控服务
 * 暂不开启安全认证   
 * 端口规划  默认2001
 * @Description 
 * @author hoob
 * @date 2019年7月11日上午11:49:27
 */



@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixDashboardApplication {
  public static void main(String[] args) {
    SpringApplication.run(HystrixDashboardApplication.class, args);
  }
 /* @Bean
  public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
      HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
      ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean(streamServlet);
      registrationBean.setLoadOnStartup(1);
      registrationBean.addUrlMappings("/hystrix.stream");
      registrationBean.setName("HystrixMetricsStreamServlet");
      return registrationBean;
  } */
/*  @Bean
  public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet(){
      HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
      ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean = new ServletRegistrationBean();
      servletRegistrationBean.setServlet(hystrixMetricsStreamServlet);
      servletRegistrationBean.addUrlMappings("/hystrix.stream");
      servletRegistrationBean.setName("HystrixMetricsStreamServlet");
      return servletRegistrationBean;
  }*/
}
