<%@ page import="com.mqxu.web.exercise.entity.Brand" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改品牌页面</title>
</head>
<body>
<%
    Brand brand = (Brand) request.getAttribute("brand");
%>
<h3>修改品牌</h3>
<form action="${pageContext.request.contextPath}/updateBrand" method="post">
    <div>
        <%--隐藏域，提交id--%>
        <input type="hidden" name="id" value="<%=brand.getId()%>">
        <label> 品牌名称：
            <input name="brandName" value="<%=brand.getBrandName()%>">
        </label>
    </div>

    <div>
        <label> 企业名称：
            <input name="companyName" value="<%=brand.getCompanyName()%>">
        </label>
    </div>

    <div>
        <label> 排序：
            <input name="ordered" value="<%=brand.getOrdered()%>">
        </label>
    </div>

    <div>
        <label> 描述信息：
            <textarea rows="5" cols="20" name="description"><%=brand.getDescription()%> </textarea>
        </label>
    </div>

    <div>
        <input type="submit" value="提交">
    </div>
</form>
</body>
</html>