package com.example.gateway.predicate;

import java.util.Collections;
import java.util.List;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;

@Component
public class AuthRoutePredicateFactory extends AbstractRoutePredicateFactory<AuthRoutePredicateFactory.Config> {

    public AuthRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("header");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            // 判断请求头里是否包含给定的 key（例如 Authorization），用于简单鉴权
            boolean hasHeader = exchange.getRequest().getHeaders().containsKey(config.getHeader());
            if (hasHeader) {
                System.out.println("认证断言通过: 请求头包含 " + config.getHeader());
            } else {
                System.out.println("认证断言失败: 请求头不包含 " + config.getHeader());
            }
            return hasHeader;
        };
    }

    public static class Config {
        private String header;

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }
    }

}
