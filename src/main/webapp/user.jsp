<%@ page import="com.example.form.dao.UserDao" %>
<%@ page import="com.example.form.dao.DbConnection" %>
<%@ page import="com.example.form.model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ilaha.Abdullayeva
  Date: 9/28/2022
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<style>
  table {
    border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    border: 1px solid #ddd;
  }

  th, td {
    text-align: left;
    padding: 16px;
  }
  thead th{
    background-color: brown;
    color: #dddddd;
  }

  tr:nth-child(even) {
    background-color: #f2f2f2;
  }


  a{
    background-color: mediumblue;
    color: white;
    padding: 14px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;}

</style>

<table >
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Surname</th>
    <th>Email</th>
    <th>Image</th>


  </tr>
  </thead>
  <tbody>

  <% int i=1;
    UserDao dao=new UserDao(DbConnection.connectDb());
    List<User> list=dao.getAllUsers();
    for (User u: list
    ) {

  %>

  <tr>
  <th>  <%
      out.print(i);
    %>
  </th>

    <th><%=u.getName()%></th>
    <th><%=u.getSurname()%></th>
    <th><%=u.getEmail()%></th>
<th> <img src="images/<%=u.getImage() %>" width="100px" height="100px" /></th>



  </tr>

  <%
      i++;

    }
  %>
  </tbody>

</table>

</body>
</html>
