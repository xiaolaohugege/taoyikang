<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.gsm.bean.Users" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 11706
  Date: 2024/12/24
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>userList</title>
</head>
<body>

<a href="<%=request.getContextPath()%>/UsersAddInputServlet">添加</a>
&nbsp;&nbsp; | &nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/UsersServlet">列表</a>

<hr color="red" width="80%" align="left">

<form action="<%=request.getContextPath()%>/UsersAddServlet" method="post">

    <table border="1" cellspacing="0" cellpadding="0" width="80%">
        <thead>

        </thead>
        <tbody>
            <tr>
                <td>用户名</td><td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td><td><input type="password" name="password_hash"></td>
            </tr>
            <tr>
                <td>邮箱</td><td><input type="email" name="email"></td>
            </tr>
            <tr>
                <td><input type="reset" value="重置"></td><td><input type="submit" value="添加"></td>
            </tr>
        </tbody>
        <tfoot>

        </tfoot>
    </table>

</form>

</body>
</html>