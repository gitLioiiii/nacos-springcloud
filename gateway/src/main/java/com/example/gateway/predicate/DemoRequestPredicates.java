package com.example.gateway.predicate;

import org.springframework.cloud.gateway.server.mvc.common.Shortcut;
import org.springframework.web.servlet.function.RequestPredicate;

public class DemoRequestPredicates {

    // 允许在配置里用短写：- auth=authorization，
    // 判断请求头里是否包含给定的 key（例如 Authorization），用于简单鉴权。
    @Shortcut
    public static RequestPredicate auth(String key) {
        return request -> request.headers().asHttpHeaders().containsKey(key);
    }

}
