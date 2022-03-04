<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>登录页面，可以显示过滤器转发过来的"用户未登录"的提示信息</h2>
<%
    String msg = (String) request.getAttribute("msg");
%>
<h3>
    ${msg}
</h3>
</body>
</html>
