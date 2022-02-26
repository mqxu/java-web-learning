package com.mqxu.bo.servlet;

import com.mqxu.bo.entity.Book;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * BookDetailServlet
 *
 * @author mqxu
 * @date 2022/02/27
 **/
@WebServlet(urlPatterns = "/detail/*")
public class BookDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的URI，并去除空格
        String requestPath = req.getRequestURI().trim();
        //获得最后一个"/"的位置
        int position = requestPath.lastIndexOf("/");
        //从该位置到最后取子串，也就是"/detail/3"中的3，有了这个id，就可以取集合中找到匹配的图书对象
        String id = requestPath.substring(position + 1);
        //从全局变量中取出图书列表
        ServletContext sc = this.getServletContext();
        List<Book> bookList = (List<Book>) sc.getAttribute("bookList");
        //遍历，查找指定id的图书
        for (Book book : bookList) {
            if (Integer.parseInt(id) == book.getId()) {
                //找到匹配的id，存入request，页面转发到图书详情页，地址栏不变
                req.setAttribute("book", book);
                req.getRequestDispatcher("/book_detail.jsp").forward(req, resp);
            }
        }
    }
}
