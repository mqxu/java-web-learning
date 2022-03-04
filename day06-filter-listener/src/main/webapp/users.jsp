<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>游戏大厅在线用户</title>
</head>
<body>
<h2>游戏大厅在线用户</h2>
<%
    Map<String, Object> sessionMap = (Map<String, Object>) request.getAttribute("sessionMap");
%>
<ul>
    <%
        for (Map.Entry<String, Object> entry : sessionMap.entrySet()) {
    %>
    <li>
        <%=entry.getValue()%>
    </li>
    <%
        }
    %>
</ul>

</body>
</html>
