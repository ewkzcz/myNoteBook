<%--
  Created by IntelliJ IDEA.
  User: ewk
  Date: 2023-01-07
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello jsp</h1>
<%
    out.println("hello jsp~");
    int num = 10;
%>
<%="hello"%>
<%=num%>
<%!
    void show(){}
    String name="张三";
%>
</body>
</html>
