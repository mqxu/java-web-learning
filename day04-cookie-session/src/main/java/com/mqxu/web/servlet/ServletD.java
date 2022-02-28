package com.mqxu.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @description: ServletD——URL解码
 * @author: mqxu
 * @date: 2022-02-28
 **/
@WebServlet(urlPatterns = "/servletD")
@Slf4j
public class ServletD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = (String) request.getAttribute("name");
        value = URLDecoder.decode(value, StandardCharsets.UTF_8);
        log.info(value);
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().write(value);
        response.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
