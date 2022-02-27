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
            BookDao bookDao = new BookDao();
            List<Book> books = bookDao.selectAll();
            request.setAttribute("books", books);
            request.getRequestDispatcher("home.jsp").forward(request, response);
            //设置编码
            response.setContentType("text/html;charset=utf-8");
            //输出
            response.getWriter().write("登录成功！" + user.getNickname() + ",欢迎您");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
