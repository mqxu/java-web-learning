<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>quickstart首页</title>
</head>
<body>
<%
    String username = (String) request.getSession().getAttribute("username");
%>
<%
    if (username != null) {
%>
<h3>
    欢迎你:<%=username%>
</h3>
<%
} else {
%>
<h3>用户未登录</h3>
<a href="${pageContext.request.contextPath}/">去登陆</a>
<%
    }
%>
</body>
</html>