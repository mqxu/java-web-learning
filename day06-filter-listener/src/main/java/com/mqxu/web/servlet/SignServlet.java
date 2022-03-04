package com.mqxu.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @description: SignServlet
 * @author: mqxu
 * @date: 2022-03-04
 **/
@WebServlet(urlPatterns = "/signServlet")
public class SignServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        req.getSession().setAttribute("username", username);
        Map<String, Object> sessionMap = (Map<String, Object>) this.getServletContext().getAttribute("sessionMap");
        req.setAttribute("sessionMap", sessionMap);
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
        //resp.sendRedirect("/users.jsp");
    }
}
