package com.gateway.factory;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;


/**
 * 自定义过滤器工厂
 *
 */
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> {

    private static final String PARAMS = "myParams";

    private static final String START_TIME = "startTime";

    public MyGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAMS);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            exchange.getAttributes().put(START_TIME, System.currentTimeMillis());
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute(START_TIME);
                        if (startTime == null) {
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("exchange request uri:" + exchange.getRequest().getURI() + ",");
                        sb.append("Time:" + (System.currentTimeMillis() - startTime) + "ms.");
                        if (config.isMyParams()) {
                            sb.append("params:" + exchange.getRequest().getQueryParams());
                        }
                    })
            );
        });
    }

    /**
     * 配置参数类
     */
    public static class Config {

        private boolean myParams;

        public boolean isMyParams() {
            return myParams;
        }

        public void setMyParams(boolean myParams) {
            this.myParams = myParams;
        }
    }
}
