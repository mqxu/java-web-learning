package com.mqxu.bo.web;

import com.mqxu.bo.dao.UserDao;
import com.mqxu.bo.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @description: 登录处理
 * @author: mqxu
 * @date: 2022-02-22
 **/
@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        System.out.println(account);
        System.out.println(password);
        //3.封装user对象
        User userDto = new User();
        userDto.setAccount(account);
        userDto.setPassword(password);
        //4.调用UserDao的login方法
        UserDao dao = new UserDao();
        User user = dao.signIn(userDto);
        //5.判断user是否为空
        if (user == null) {
            //登录失败
            req.getRequestDispatcher("/fail").forward(req, resp);
        } else {
            //登录成功,存储数据
            req.setAttribute("user", user);
            //转发
            req.getRequestDispatcher("/success").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

