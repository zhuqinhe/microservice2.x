package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * 端口规划  6901
 * @Description 
 * @author hoob
 * @date 2020年5月12日下午10:48:31
 */
@EnableHystrix 
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class MicroserviceBookmarkConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBookmarkConsumerApplication.class, args);
	}
}
