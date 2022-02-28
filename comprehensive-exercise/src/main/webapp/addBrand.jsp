<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加品牌</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="${pageContext.request.contextPath}/addBrand" method="post">
    <div>
        <label>品牌名称：
            <input name="brandName">
        </label>
    </div>

    <div>
        <label> 企业名称：
            <input name="companyName">
        </label>
    </div>

    <div>
        <label> 排序：
            <input name="ordered">
        </label>
    </div>

    <div>
        <label> 描述信息：
            <textarea rows="5" cols="20" name="description"></textarea>
        </label>
    </div>

    <div>
        状态：
        <label>禁用
            <input type="radio" name="status" value="0">
        </label>
        <label>启用
            <input type="radio" name="status" value="1">
        </label>
    </div>

    <div>
        <input type="submit" value="提交">
    </div>
</form>

</body>
</html>