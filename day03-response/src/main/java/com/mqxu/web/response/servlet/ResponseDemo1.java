package com.mqxu.web.response.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 重定向
 *
 * @author mqxu
 */

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseDemo1........");
        //访问/responseDemo1，会自动跳转到/responseDemo2资源
        //1. 设置状态码为302
        response.setStatus(302);
        //2.设置响应头location
        response.setHeader("location", "/day03/responseDemo2");
        request.setAttribute("msg", "response");
        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        //简单的重定向方法
        response.sendRedirect(contextPath + "/responseDemo2");
        // 重定向可以跨域访问
        //response.sendRedirect("https://www.baidu.cn");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
