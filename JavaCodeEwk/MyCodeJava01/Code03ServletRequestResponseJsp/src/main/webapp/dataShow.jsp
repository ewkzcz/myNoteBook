<%--
  Created by IntelliJ IDEA.
  ewk.code16.data.User: ewk
  Date: 2023-01-07
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  <!-- 版本问题: core -> core_rt-->
<html>
<head>
    <title>Title</title>
    <style>
        table{border: aqua solid}
        tr{align-content: center}
    </style>
</head>
<body>
<h1>dataShow</h1>
    ${dataList}
    <br>

    <c:if test="${status==1}">
        启用
    </c:if>
    <c:if test="${status==0}">
        禁用
    </c:if>

    <table>
        <c:forEach items="${dataList}" var="brand">
            <tr>
                <td>${brand.id}</td>
                <td>${brand.name}</td>
                <td>${brand.age}</td>
                <td>${brand.bir}</td>
                <c:if test="${status == 1}">
                    <td>启用</td>
                </c:if>
                <c:if test="${status != 1}">
                    <td>禁用</td>
                </c:if>
                <td>${status}</td>
                <td>
                    <a href="">修改</a>
                    <a href="">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <hr>普通forEach:<br>
    <c:forEach begin="1" end="10" step="1" var="i">
        <a href="">${i}</a>
    </c:forEach>
</body>
</html>
