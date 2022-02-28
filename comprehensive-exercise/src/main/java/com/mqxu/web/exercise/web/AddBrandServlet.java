package com.mqxu.web.exercise.web;

import com.mqxu.web.exercise.entity.Brand;
import com.mqxu.web.exercise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @description: 新增品牌逻辑处理
 * @author: mqxu
 * @date: 2022-02-28
 **/
@WebServlet(urlPatterns = "/addBrand")
@Slf4j
public class AddBrandServlet extends HttpServlet {

    private final BrandService brandService = new BrandService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收表单提交的数据，封装为一个Brand对象
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        //封装为一个Brand对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));

        //2. 调用service 完成添加
        brandService.add(brand);

        //3. 重定向到查询所有Servlet
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/index");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}