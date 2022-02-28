package com.mqxu.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @description: ServletC——URL编码
 * @author: mqxu
 * @date: 2022-02-28
 **/
@WebServlet(urlPatterns = "/servletC")
@Slf4j
public class ServletC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = "你好";
        value = URLEncoder.encode(value, StandardCharsets.UTF_8);
        log.info(value);
        request.setAttribute("name", value);
        request.getRequestDispatcher("/servletD").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
