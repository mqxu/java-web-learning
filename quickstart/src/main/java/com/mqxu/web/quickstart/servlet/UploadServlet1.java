package com.mqxu.web.quickstart.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.UUID;

/**
 * 处理axios通过formData提交的多文件上传请求，同时formData里还有其他参数
 *
 * @author mqxu
 */
@WebServlet(urlPatterns = "/upload1")
@MultipartConfig
public class UploadServlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取提交数据中的account
        String account = request.getParameter("account");
        System.out.println(account);

        Part part = request.getPart("file");
        // 原文件名
        System.out.println(part.getSubmittedFileName());

        String fileName = "";

        if (part.getContentType() != null) {
            // 给文件改名
            fileName = UUID.randomUUID() + part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
            // 获取项目部署的绝对路径
            ServletContext context = this.getServletContext();
            // 文件上传最终的目录/文件名
            String realPath = context.getRealPath("upload/" + fileName);
            // 上传
            part.write(realPath);
        }

        // 把上传图片的相对路径返回给客户端
        PrintWriter out = response.getWriter();
        out.write("./upload/" + fileName);
        out.flush();
        out.close();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
