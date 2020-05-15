package com.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gateway.factory.MyGatewayFilterFactory;


@Configuration
public class FilterFactory {

    @Bean
    public MyGatewayFilterFactory myGatewayFilterFactory() {
        return new MyGatewayFilterFactory();
    }
}
