package com.mqxu.bo.web;

import com.mqxu.bo.dao.BookDao;
import com.mqxu.bo.entity.Book;
import com.mqxu.bo.entity.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @description:
 * @author: mqxu
 * @date: 2022-02-22
 **/
@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取request域中共享的user对象
        User user = (User) request.getAttribute("user");
        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/home");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
