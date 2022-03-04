package com.mqxu.web.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @description: 登录状态校验过滤器
 * @author: mqxu
 * @date: 2022-03-04
 **/
//@WebFilter(urlPatterns = "/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 登录状态校验逻辑代码
        // 0. 将ServletRequest对象强制转化为HttpServletRequest对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 1. 判断访问资源路径是否和登录注册相关
        //1.1 在数组中存储登陆和注册相关的资源路径
        String[] urls = {"/login.jsp", "/img/", "/css/", "/js", "/loginServlet", "/register.jsp", "/registerServlet", "/verifyCodeServlet","/sign.html","users.jsp"};
        //1.2 获取当前访问的资源路径
        String url = request.getRequestURL().toString();
        //1.3 遍历数组，获取到每一个需要放行的资源路径
        for (String u : urls) {
            //1.4 判断当前访问的资源路径，是否包含要放行的的资源路径
            // 比如当前访问的资源路径是 /page/login.jsp, 而字符串 /page/login.jsp 包含了字符串 /login.jsp ，所以这个字符串就需要放行
            if (url.contains(u)) {
                //找到了，放行
                filterChain.doFilter(request, servletResponse);
                return;
            }
        }

        // 2. 取出session，并取出user
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        // 3. 判断user是否为null
        if (user != null) {
            // 登录过了，放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 没有登录，直接跳到登录页面
            String msg = "当前用户没有登录";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter销毁");
    }
}
