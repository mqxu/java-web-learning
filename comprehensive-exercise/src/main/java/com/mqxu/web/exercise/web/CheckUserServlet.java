package com.mqxu.web.exercise.web;

import com.mqxu.web.exercise.entity.User;
import com.mqxu.web.exercise.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.invoke.VarHandle;

/**
 * @description: 验证用户名是否可用
 * @author: mqxu
 * @date: 2022-02-28
 **/
@WebServlet(urlPatterns = "/check")
public class CheckUserServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        User user = User.builder().username(username).build();
        boolean flag = userService.register(user);
        response.getWriter().write(String.valueOf(flag));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
