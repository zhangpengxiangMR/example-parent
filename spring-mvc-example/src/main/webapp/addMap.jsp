<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/20
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/data/map" method="post">
    用户0编号：<input name="users['a'].id" type="text"/>
    用户0名称：<input name="users['a'].name" type="text"/>
    用户1编号：<input name="users['b'].id" type="text"/>
    用户1名称：<input name="users['b'].name" type="text"/>
    用户2编号：<input name="users['c'].id" type="text"/>
    用户3名称：<input name="users['c'].name" type="text"/>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
