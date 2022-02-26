package com.mqxu.web.quickstart.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @description: 模拟HTTP请求
 * @author: mqxu
 * @date: 2022-02-27
 **/
public class MockHttp {
    /**
     * 向指定URL发送GET方法的请求，请求参数可有可无
     *
     * @ url 发送请求的url
     * @ param1/2 请求参数,可有可无，格式必须是name1=value1&name2=value2
     * @ return 请求响应内容
     */
    public static void main(String[] args) throws Exception {
        //打开和目标URL的HTTP链接
        URLConnection connection = new URL("http://localhost:8080/students").openConnection();
        HttpURLConnection httpUrlConnection = (HttpURLConnection) connection;
        //设置请求方式
        httpUrlConnection.setRequestMethod("GET");
        //设置通用请求属性
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        //建立实际连接
        connection.connect();
        //获取响应头部，遍历输出
        Map<String, List<String>> map = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
            System.out.println(header.getKey() + "=" + header.getValue());
        }
        //获取响应状态码和响应消息
        int resCode = httpUrlConnection.getResponseCode();
        String message = httpUrlConnection.getResponseMessage();
        System.out.println("状态码" + resCode + ",响应消息" + message);
        //输出响应体
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder result = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            result.append("\n").append(inputLine);
        }
        System.out.println("result===" + result);
    }
}
