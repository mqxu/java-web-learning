package com.mqxu.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @description: 获取Session对象、存储数据
 * @author: mqxu
 * @date: 2022-02-28
 **/
@WebServlet("/demo1")
@Slf4j
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = "zhangsan";
        // 1. 获取Session对象
        HttpSession session = request.getSession();
        // 打印session
        log.info(String.valueOf(session));
        //2. 存储数据
        session.setAttribute("username", info);
        response.getWriter().write(info);
        response.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
