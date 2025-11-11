package com.example.gateway.filter;

import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

@Component
public class GlobalWebFilter implements WebFilter, Ordered {

    @Override
    public int getOrder() {
        return -100; // 确保在其他过滤器之前执行
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 添加 CORS 头
        HttpHeaders headers = response.getHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");
        headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        headers.add("Access-Control-Max-Age", "3600");
        headers.add("Access-Control-Allow-Credentials", "true");

        System.out.print(
            """
            >>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            所有请求都会先经过这里。
            Global WebFilter - CORS 已设置
            >>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            """
        );

        // 处理预检请求 (OPTIONS)
        if (request.getMethod() == HttpMethod.OPTIONS) {
            response.setStatusCode(HttpStatus.OK);
            System.out.println("处理 OPTIONS 预检请求");
            return Mono.empty();
        }

        return chain.filter(exchange);
    }

}
