package com.mqxu.web.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @description: AjaxServlet1——接收axios请求
 * @author: mqxu
 * @date: 2022-03-02
 **/
@WebServlet(urlPatterns = "/ajaxServlet1")
@Slf4j
public class AjaxServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this.doGet(req, resp);
        String username = req.getParameter("username");
        log.info(username);
        resp.getWriter().write("Hello Ajax," + username);
    }
}
