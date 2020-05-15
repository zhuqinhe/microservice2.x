package com.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;



import reactor.core.publisher.Mono;

public class AuthenGatewayFilter implements GlobalFilter, Ordered {
	/**
	 * @Title filter
	 * @Description 
	 * @param 
	 * @return GlobalFilter
	 * @throws 
	 */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       //鉴权,具体业务自己填充
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        ServerHttpRequest request = exchange.getRequest();
        //token对象,有可能在请求头传递过来，也有可能是通过参数传过来，实际开发一般都是请求头方式
        if(uname == null) {
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
    
        return chain.filter(exchange);
    }

    /**
     * 加载过滤器的顺序，数据越小，优先级越高
     * @return int
     */
    @Override
    public int getOrder() {
        return 0;
    }

}

