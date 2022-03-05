package com.mqxu.web.brand.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 替换HttpServlet,根据请求的最后一段路径来进行方法分发
 *
 * @author mqxu
 */
public class BaseServlet extends HttpServlet {

    /**
     * 根据请求的最后一段路径来进行方法分发
     *
     * @param req  请求对象
     * @param resp 响应对象
     * @throws ServletException 异常
     * @throws IOException      异常
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求路径
        // /brand-case/brand/selectAll
        String uri = req.getRequestURI();
        // System.out.println(uri);
        //2. 获取最后一段路径，方法名
        int index = uri.lastIndexOf('/');
        //  /selectAll? selectAll?
        String methodName = uri.substring(index + 1);
        // System.out.println(methodName);

        //2. 执行方法
        //2.1 获取BrandServlet /UserServlet 字节码对象 Class
        //System.out.println(this);
        Class<? extends BaseServlet> cls = this.getClass();
        //2.2 获取方法 Method对象
        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //2.3 执行方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
