<%--
  Created by IntelliJ IDEA.
  ewk.code16.data.User: ewk
  Date: 2023-01-07
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加品牌</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/addServlet" method="post">
    ID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="id"><br>
    品牌名称: <input name="brandName"><br>
    企业名称: <input name="enterpriseName"><br>
    描述信息: <textarea rows="5" cols="20" name="introduce"></textarea><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
