<%@ page import="com.mqxu.web.exercise.entity.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mqxu.web.exercise.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>品牌主页</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("user");
    List<Brand> brands = (List<Brand>) request.getAttribute("brands");
%>
<h1><%=user.getUsername()%>,欢迎您</h1>

<div class="container">
    <input type="button" value="新增" id="add">
    <hr>
    <table>
        <tr>
            <th>序号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>品牌介绍</th>
            <th>状态</th>
            <th>操作</th>
        </tr>

        <%
            for (Brand brand : brands) {
        %>
        <tr>
            <td><%=brand.getId()%>
            </td>
            <td><%=brand.getBrandName()%>
            </td>
            <td><%=brand.getCompanyName()%>
            </td>
            <td><%=brand.getOrdered()%>
            </td>
            <td><%=brand.getDescription()%>
            </td>
            <td>
                <%
                    if (brand.getStatus() == 0) {
                %>
                禁用
                <%
                } else {
                %>
                启用
                <%
                    }
                %>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/selectById?id=<%=brand.getId()%>">修改</a>
                <a href="#">删除</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>


<script>
    document.getElementById("add").onclick = function () {
        location.href = "/addBrand.jsp";
    }
</script>
</body>
</html>