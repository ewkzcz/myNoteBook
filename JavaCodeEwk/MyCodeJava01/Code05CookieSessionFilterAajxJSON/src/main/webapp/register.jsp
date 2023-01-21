<%--
  Created by IntelliJ IDEA.
  ewk.code16.data.User: ewk
  Date: 2023-01-08
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
  <title>添加品牌</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="" method="post">
  <table>
    <tr>
      <td>ID:</td>
      <td>
        <input name="id" id="id">
        <span id="idError" style="display: none">id长度不超过6</span>
      </td>
    </tr>
    <tr>
      品牌名称:
      <td>品牌名称:</td>
      <td>
        <input name="brandName" id="brandName">
      </td>
    </tr>
    <tr>
      <td>企业名称:</td>
      <td>
        <input name="enterpriseName" id="enterpriseName">
      </td>
    </tr>
    <tr>
      <td>描述信息:</td>
      <td>
        <textarea rows="5" cols="20" name="introduce" id="introduce"></textarea>
      </td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="提交">
      </td>
    </tr>
  </table>
</form>
<script>
  document.getElementById("id").onblur = function (){  // 失去焦点,则发送请求
    var id = this.value;
    // 1.创建核心对象
    var xhttp;
    if (window.XMLHttpRequest) {
      xhttp = new XMLHttpRequest();
    } else {  // code for IE6, IE5
      xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    // 2.向服务器发送请求
    xhttp.open("GET", "http://localhost:8080/ajax1?id="+id, true);
    xhttp.send();
    // 3.获取响应
    xhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        if (this.responseText.length > 6){
          document.getElementById("idError").style.display = '';
        }
        else{
          document.getElementById("idError").style.display = 'none';
        }
      }
    };
  }
</script>
</body>
</html>
