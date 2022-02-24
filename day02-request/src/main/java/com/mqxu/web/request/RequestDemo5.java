package com.mqxu.web.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Request对象：获取请求消息体--请求参数
 *
 * @author mqxu
 * @date 2022.02.24
 */
@WebServlet("/requestDemo5")
public class RequestDemo5 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求消息体--请求参数
        //1.获取字符流
        BufferedReader br = request.getReader();
        //2.读取数据
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
