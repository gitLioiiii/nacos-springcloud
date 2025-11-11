package com.example.gateway.predicate;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.cloud.gateway.server.mvc.predicate.PredicateSupplier;

public class DemoPredicateSupplier implements PredicateSupplier {

    // 实现 PredicateSupplier#get()，返回一个方法集合。
    // 这里把 DemoRequestPredicates 类里的所有 public static 方法返回给网关去注册。
    @Override
    public Collection<Method> get() {
        return Arrays.asList(DemoRequestPredicates.class.getMethods());
    }

}
