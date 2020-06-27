<%@ page import="com.pykj.tomcat.entity.Users" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/6
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<table>
    <tr>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <c:forEach items="${usersList}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
</table>
<hr/>
<c:set var="name" value="1" scope="request"></c:set>
${name}
<hr/>
<%
    Users users = new Users("张三", 18);
    request.setAttribute("user", users);
%>
${user.name}
<hr/>
<c:set target="${user}" property="name" value="lisi"></c:set>
${user.name}
<hr/>
<c:set var="tar" value="tom"></c:set>
<c:out value="${tar}" default="没有定义"></c:out>
<hr/>
<c:remove var="tar"></c:remove>
<c:out value="${tar}" default="没有定义"></c:out>
<hr/>
<c:catch var="error">
    <%
        int i = 10 / 0;
    %>
</c:catch>
${error}
<%--<c:if test=""></c:if>
<c:choose>
    <c:when test=""></c:when>
    <c:otherwise></c:otherwise>
</c:choose>--%>
<%--<c:forEach items="userlist" var="" begin="" end="" step="" varStatus="">

</c:forEach>--%>
<hr/>
<%
    request.setAttribute("data", new Date());
%>
<fmt:formatDate value="${data}" pattern="yyy-MM-dd HH:mm:ss"></fmt:formatDate> <br/>
<fmt:formatNumber value="32145.23434" maxIntegerDigits="2" maxFractionDigits="3"></fmt:formatNumber>
<hr/>
<%
    request.setAttribute("info", "java,c");
%>
${fn:contains(info,"Python" )}<br/>
${fn:startsWith(info, "java")}<br/>
${fn:endsWith(info, "c")}<br/>
${fn:indexOf(info, "va")}<br/>
${fn:replace(info, "c","Python" )}<br/>
${fn:substring(info, 2, 3)}<br/>
${fn:split(info,"," )[0]}-${fn:split(info, ",")[1]}
</body>
</html>
