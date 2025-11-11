package com.example.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.gateway.filter.DemoFilterSupplier;
import com.example.gateway.predicate.DemoPredicateSupplier;

@Configuration
public class DemoConfiguration {

    // 自定义过滤器
    @Bean
    public DemoFilterSupplier demoFilterSupplier() {
        return new DemoFilterSupplier();
    }

    // 谓语，断言
    @Bean
    public DemoPredicateSupplier demoPredicateSupplier() {
        return new DemoPredicateSupplier();
    }

}
