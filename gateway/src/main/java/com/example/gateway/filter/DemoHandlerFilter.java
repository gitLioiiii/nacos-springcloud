package com.example.gateway.filter;

import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.ServerResponse;

public class DemoHandlerFilter {

    public static HandlerFilterFunction<ServerResponse, ServerResponse> log() {
        return (request, next) -> {
            System.out.print(
                """
                ==============================
                每次匹配的路由执行时打印日志，
                使用filters: - log启用此过滤器
                logging...
                ==============================
                """
            );
            return next.handle(request);
        };
    }

}
