package com.mqxu.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词汇过滤器
 *
 * @author mqxu
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    /**
     * 敏感词汇集合
     */
    private final List<String> list = new ArrayList<>();

    /**
     * 需要执行的目标方法
     */
    private final String methodName = "getParameter";

    @Override
    public void init(FilterConfig config) throws ServletException {
        try {
            //1.获取文件真实路径，取出发布后的敏感词汇文本文件
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            //2.读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            //3.将文件的每一行数据添加到list中
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象，增强getParameter方法
        ServletRequest proxyReq = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), (proxy, method, args) -> {
            //增强getParameter方法
            if (methodName.equals(method.getName())) {
                //增强返回值，并获取
                String value = (String) method.invoke(req, args);
                if (value != null) {
                    for (String str : list) {
                        if (value.contains(str)) {
                            // 替换为****
                            value = value.replaceAll(str, "***");
                        }
                    }
                }
                return value;
            }
            // 执行目标方法，并返回执行结果
            return method.invoke(req, args);
        });
        //2.放行
        chain.doFilter(proxyReq, resp);
    }


    @Override
    public void destroy() {
        System.out.println("敏感词过滤器被销毁");
    }

}
