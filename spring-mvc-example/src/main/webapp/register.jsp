<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/27
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form:form modelAttribute="person" action="/validator/register" method="post">
        姓名：<form:input path="userName"/><form:errors path="userName"/><br/>
        密码：<form:input path="password"/><form:errors path="password"/><br/>
        <input type="submit" value="提交"/>
    </form:form>

</body>
</html>
