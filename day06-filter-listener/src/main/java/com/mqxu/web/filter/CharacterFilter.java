package com.mqxu.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @description: 编码过滤器
 * @author: mqxu
 * @date: 2022-03-04
 **/
@WebFilter(filterName = "CharacterFilter", urlPatterns = "/*")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("CharacterFilter初始化");
    }

    @Override
    public void destroy() {
        System.out.println("CharacterFilter销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }
}
