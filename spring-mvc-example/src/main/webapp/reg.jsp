<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/14
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>reg</title>
</head>
<body>

<form action="/index/save" method="post">
    用户id:<input type="text" name="id"> <br/>
    用户名名称：<input type="text" name="name"><br/>
    地址：<input type="text" name="address.name"/><br/>
    <input type="submit" value="注册">
</form>

</body>
</html>
