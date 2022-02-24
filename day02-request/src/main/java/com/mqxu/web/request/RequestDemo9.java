package com.mqxu.web.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Request对象：forward转发
 *
 * @author mqxu
 * @date 2022.02.24
 */
@WebServlet("/requestDemo9")
public class RequestDemo9 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从request域中获取数据
        Object msg = request.getAttribute("msg");
        System.out.println(msg);
        System.out.println("demo9被访问了。。。");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
