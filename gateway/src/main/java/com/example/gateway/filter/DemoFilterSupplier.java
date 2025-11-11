package com.example.gateway.filter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.cloud.gateway.server.mvc.filter.FilterSupplier;

public class DemoFilterSupplier implements FilterSupplier {

    @Override
    public Collection<Method> get() {
        return Arrays.asList(DemoHandlerFilter.class.getMethods());
    }

}
