package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    public LogGatewayFilterFactory() {
        super(Object.class);
    }

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            System.out.print(
                """
                ==============================
                每次匹配的路由执行时打印日志，
                使用filters: - Log启用此过滤器
                logging...
                请求路径: %s
                请求方法: %s
                ==============================
                """.formatted(
                    exchange.getRequest().getURI().getPath(),
                    exchange.getRequest().getMethod()
                )
            );
            return chain.filter(exchange);
        };
    }

}
