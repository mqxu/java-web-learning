package com.mqxu.web.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @description: 过滤器demo
 * @author: mqxu
 * @date: 2022-03-04
 **/
//@WebFilter(urlPatterns = "/*")
public class FilterDemo2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器2初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("44444");
        //放行，放请求访问其本该访问的资源
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("55555");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器2销毁");
    }
}
