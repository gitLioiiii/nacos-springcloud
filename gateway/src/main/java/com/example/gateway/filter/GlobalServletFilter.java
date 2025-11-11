package com.example.gateway.filter;

import java.io.IOException;

import org.springframework.cloud.gateway.server.mvc.filter.FormFilter;
import org.springframework.core.Ordered;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class GlobalServletFilter implements Filter, Ordered {

    // getOrder() 返回 FormFilter.FORM_FILTER_ORDER - 1，
    // 确保执行顺序在表单过滤器之前
    @Override
    public int getOrder() {
        return FormFilter.FORM_FILTER_ORDER - 1;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // 添加 CORS 头
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        
        System.out.print(
            """
            >>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            所有请求都会先经过这里。
            Global filter - CORS 已设置
            >>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            """
        );
        
        // 处理预检请求 (OPTIONS)
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            System.out.println("处理 OPTIONS 预检请求");
            return;
        }
        
        chain.doFilter(request, response);
    }

}
