<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/6
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="text" name="desc"/><br/><br/>
        <input type="file" name="file"/><br/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
