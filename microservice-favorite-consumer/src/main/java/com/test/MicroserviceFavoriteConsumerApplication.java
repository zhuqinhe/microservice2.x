package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

/**
 * 微服务测试接入入口  
 * 端口规划  6801
 * @Description 
 * @author hoob
 * @date 2020年5月12日下午10:48:31
 */
@EnableFeignClients
@EnableHystrix 
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceFavoriteConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceFavoriteConsumerApplication.class, args);
	}
}
