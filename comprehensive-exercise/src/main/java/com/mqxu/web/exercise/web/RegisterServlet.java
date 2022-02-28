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

/**
 * @description:
 * @author: mqxu
 * @date: 2022-02-28
 **/
@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取用户名和密码数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // 获取用户输入的验证码
        String inputCode = request.getParameter("inputCode");

        // 程序生成的验证码，从Session获取
        HttpSession session = request.getSession();
        String verifyCode = (String) session.getAttribute("verifyCode");
        response.setContentType("text/html;charset=utf-8");
        String contextPath = request.getContextPath();

        // 忽略大小写比对
        if (!verifyCode.equalsIgnoreCase(inputCode)) {
            //验证码错误，跳回注册页面
            response.getWriter().write("<script>alert('验证码错误');location='/register.html';</script>");
        }
        //2. 调用service 注册
        boolean flag = userService.register(user);

        //3. 判断注册成功与否
        if (flag) {
            //注册成功，跳转登陆页面
            response.getWriter().write("<script>alert('注册成功');location='/login.html';</script>");
        } else {
            //用户名已存在，注册失败，跳回注册页面
            response.getWriter().write("<script>alert('用户名已存在');location='/register.html';</script>");
        }
    }
}
