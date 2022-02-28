package com.mqxu.web.exercise.web;

import com.mqxu.web.exercise.entity.Brand;
import com.mqxu.web.exercise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @description: 首页，查询所有品牌
 * @author: mqxu
 * @date: 2022-02-28
 **/
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用BrandService完成查询
        List<Brand> brands = brandService.selectAll();
        //2. 存入request域中
        request.setAttribute("brands", brands);
        //3. 转发到brand.jsp
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}