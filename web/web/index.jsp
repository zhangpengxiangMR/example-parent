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
  <h1>index.jsp</h1>
  <%!
    public String test(){
      return "Hello word";
    }
  %>
  <%
    String test = test();
  %>
  <%=test%>

  <%
    List<String> names = new ArrayList<>();
    names.add("张三");
    names.add("李四");
    names.add("王五");
    List<Integer> ages = new ArrayList<>();
    ages.add(18);
    ages.add(28);
    ages.add(38);
  %>

  <table>
    <tr>
      <td>姓名</td>
      <td>年龄</td>
    </tr>
    <%
      for (int i =0 ;i < names.size();i++) {
    %>
    <tr>
      <td>
        <%=names.get(i)%>
      </td>
      <td>
        <%=ages.get(i)%>
      </td>
    </tr>
    <%
      }
    %>
  </table>


  <%
    List<Users> usersList = new ArrayList<Users>();
    usersList.add(new Users("张鹏祥",18));
    usersList.add(new Users("熊珍",18));
  %>
  <table>
    <tr>
      <td>姓名</td>
      <td>年龄</td>
    </tr>
    <%
      for (int i =0 ;i < usersList.size();i++) {
    %>
    <tr>
      <td>
        <%=usersList.get(i).getName()%>
      </td>
      <td>
        <%=usersList.get(i).getAge()%>
      </td>
    </tr>
    <%
      }
    %>
    <%
      String name = request.getParameter("name");
      Integer integer = Integer.parseInt(name);
      integer++;
      request.setAttribute("number",integer);
      request.getRequestDispatcher("index2.jsp").forward(request,response);
    %>
    <%=name%>
  </table>

  </body>
</html>
