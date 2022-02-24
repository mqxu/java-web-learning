package com.mqxu.web.response.servletcontext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ServletContext功能 ：获取文件的真实(服务器)路径
 *
 * @author mqxu
 */
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过HttpServlet获取
        ServletContext context = this.getServletContext();
        // 获取文件的服务器路径
        //web目录下资源访问
        String b = context.getRealPath("/b.txt");
        System.out.println(b);
        // File file = new File(realPath);
        //WEB-INF目录下的资源访问
        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);

        //src目录下的资源访问
        String a = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(a);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
