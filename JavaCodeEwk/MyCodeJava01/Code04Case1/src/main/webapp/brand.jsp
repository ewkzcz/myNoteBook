<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  <!-- 版本问题: core -> core_rt-->
<html>
<head>
    <title>Title</title>
    <style>
        div{text-align: center}
        table{border:solid #000000; border-width:1px 0px 0px 1px;}
        td{border:solid #000000; border-width:0px 1px 1px 0px;}
    </style>
</head>
<body>
<input type="button" value="新增" id="add"><br>
<div>
    <table>
        <c:forEach items="${brandList}" var="brand">
            <tr>
                <td>${brand.id}</td>
                <td>${brand.brandName}</td>
                <td>${brand.enterpriseName}</td>
                <td>${brand.introduce}</td>
                <td>
                    <a href="/selectByIdServlet?id=${brand.id}">修改</a>
                    <a href="">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
    document.getElementById("add").onclick = function (){
        location.href = "/addBrand.jsp";
    }
</script>
</body>
</html>
