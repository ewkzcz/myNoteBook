<%--
  Created by IntelliJ IDEA.
  User: ewk
  Date: 2023-01-07
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>修改品牌</title>
    <style>
        textarea{vertical-align: top;}
    </style>
</head>
<body>
<h3>修改品牌</h3>
<form action="/updateServlet" method="post">
    <!-- 隐藏域: 提交id -->
    <input type="hidden" name="id" value="${brand.id}">

    ID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="id" value="${brand.id}"><br>
    品牌名称: <input name="brandName" value="${brand.brandName}"><br>
    企业名称: <input name="enterpriseName" value="${brand.enterpriseName}"><br>
    描述信息: <textarea rows="2" cols="22" name="introduce">${brand.introduce}</textarea><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
