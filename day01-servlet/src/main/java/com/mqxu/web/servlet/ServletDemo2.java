package com.mqxu.web.servlet;


import jakarta.servlet.*;

import java.io.IOException;

/**
 * Servlet接口中的方法
 *
 * @author mqxu
 * @date 2022.02.24
 */
public class ServletDemo2 implements Servlet {
    private static int age = 3;

    /**
     * 初始化方法
     * 在Servlet被创建时执行，只会执行一次
     *
     * @param servletConfig servlet配置对象
     * @throws ServletException servlet异常
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 获取ServletConfig配置对象
     *
     * @return ServletConfig
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每一次Servlet被访问时执行，可以执行多次
     *
     * @param servletRequest  请求对象
     * @param servletResponse 响应对象
     * @throws ServletException Servlet异常
     * @throws IOException      IO异常
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("执行service...");
        age++;
        System.out.println(age + "岁");
    }

    /**
     * 获取Servlet的一些信息：版本、作者等等
     *
     * @return String
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时执行，只执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy.....");
    }
}
