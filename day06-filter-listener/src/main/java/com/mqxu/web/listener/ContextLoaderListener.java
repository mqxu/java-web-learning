package com.mqxu.web.listener;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: ContextLoaderListener：对ContextLoaderListener对象进行监听（创建、销毁）
 * HttpSessionListener：对Session对象的整体状态监听（创建、销毁）
 * HttpSessionAttributeListener: 对Session对象d的属性的新增或移除、修改等操作监听
 * @author: mqxu
 * @date: 2022-03-04
 **/
@WebListener
public class ContextLoaderListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    private static Map<String, Object> sessionMap;

    public ContextLoaderListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //加载资源
        System.out.println("ContextLoaderListener初始化，加载资源...");
        sessionMap = new HashMap<>(8);
        sce.getServletContext().setAttribute("sessionMap", sessionMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //释放资源
        System.out.println("ContextLoaderListener销毁，释放资源...");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated，创建了新的会话");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed，销毁了会话");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        System.out.println(session.getAttribute("username") + "上线了...");
        sessionMap.put(session.getId(), session.getAttribute("username"));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        System.out.println(session.getAttribute("username") + "下线了...");
        sessionMap.remove(session.getId(), session.getAttribute("username"));
    }

}
