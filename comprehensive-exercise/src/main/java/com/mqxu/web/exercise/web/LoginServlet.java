package com.mqxu.web.exercise.web;

import com.mqxu.web.exercise.entity.User;
import com.mqxu.web.exercise.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * @description: 登录逻辑处理
 * @author: mqxu
 * @date: 2022-02-28
 **/
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 是否勾选了"记住我"
        String remember = request.getParameter("remember");
        System.out.println(remember + "_________________________");
        // 2. 调用service登录
        User user = userService.login(username, password);

        // 3. 判断
        if (user != null) {
            // 非空，登录成功
            // 是否勾选了记住我
            if ("on".equals(remember)) {
                System.out.println("需要记录Cookie");
                // 1.创建Cookie对象
                Cookie cUserName = new Cookie("username", username);
                Cookie cPassword = new Cookie("password", password);
                //2. 设置存活时间
                cUserName.setMaxAge(60 * 60 * 24 * 7);
                cPassword.setMaxAge(60 * 60 * 24 * 7);
                // 3.发送
                response.addCookie(cUserName);
                response.addCookie(cPassword);
            }
            // 将用户信息记在session中
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String contextPath = request.getContextPath();
            System.out.println(contextPath);
            response.sendRedirect(contextPath + "/index");
        } else {
            // 登录失败
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('用户名或密码错误');location='/login.html';</script>");
        }
    }
}
