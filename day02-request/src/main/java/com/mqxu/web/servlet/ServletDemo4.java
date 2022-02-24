package com.mqxu.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet路径配置 , urlPatterns
 * @author mqxu
 */
//@WebServlet({"/d4","/dd4","/ddd4"})
//@WebServlet("/user/demo4")
//@WebServlet("/user/*")
//@WebServlet("/*")
@WebServlet("*.do")
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4...");
        System.out.println(req);
    }
}
