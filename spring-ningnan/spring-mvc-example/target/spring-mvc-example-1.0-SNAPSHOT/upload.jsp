<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/26
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/file/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="img"/>
    <input type="submit" value="上传"/>
</form>

</body>
</html>
