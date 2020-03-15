<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pykj.tomcat.entity.Users" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/4
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  <h1>index2.jsp</h1>

  <%
    Integer integer = (Integer)request.getAttribute("number");
  %>
  <%=integer%>
  </body>
</html>
