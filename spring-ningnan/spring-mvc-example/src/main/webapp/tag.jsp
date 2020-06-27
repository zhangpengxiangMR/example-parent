<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/27
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>学生信息</h1>
<form:form modelAttribute="student">
    学生ID:<form:input path="id"/><br/>
    学生姓名:<form:input path="name"/><br/>
    学生年龄:<form:input path="age"/><br/>
    <input type="submit" value="提交"/>
</form:form>
</body>
</html>
