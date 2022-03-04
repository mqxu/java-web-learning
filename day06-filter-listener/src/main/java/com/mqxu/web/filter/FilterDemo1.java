package com.mqxu.web.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

/**
 * @description: 过滤器demo
 * @author: mqxu
 * @date: 2022-03-04
 **/
//@WebFilter(urlPatterns = "/*")
public class FilterDemo1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器1初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("11111");
        //放行，放请求访问其本该访问的资源
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("33333");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器1销毁");
    }
}
