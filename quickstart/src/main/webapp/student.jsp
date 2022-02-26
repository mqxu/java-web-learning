<%@ page import="java.util.List" %>
<%@ page import="com.mqxu.web.quickstart.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>学生信息显示</title>
    <style>
        <%--页面主容器，左右均等留白，设置背景色和上下内边距 --%>
        .container {
            width: 80%;
            margin: 0 auto;
            background-color: #9b9b9b;
            padding-top: 10px;
            padding-bottom: 10px;
        }

        <%--展示每个学生数据的div，横向flex布局，水平和垂直方向均居中对齐 --%>
        .item {
            width: 80%;
            margin: 0 auto;
            height: 80px;
            background-color: #eee;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 5px 5px 5px 5px;
        }

        .item span {
            margin-right: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <%
        // 从request对象取出studentList参数
        List<Student> studentList = (List<Student>) request.getAttribute("studentList");
        //遍历集合
        for (Student student : studentList) {
            //将每个Student对象存入当前页面的内置对象，便于用EL表达式展现对象的信息
            request.setAttribute("student", student);
    %>
    <%-- 循环产生div，用来展示每个Student对象的数据--%>
    <div class="item">
        <span>${student.id}</span>
        <span>${student.name}</span>
        <span>${student.gender}</span>
        <span>${student.age}</span>
    </div>
    <%
        }
    %>
</div>
</body>
</html>