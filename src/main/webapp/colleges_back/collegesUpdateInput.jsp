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

<a href="<%=request.getContextPath()%>/CollegesServlet?requestMethod=addInput">添加</a>
&nbsp;&nbsp; | &nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/CollegesServlet?requestMethod=list">列表</a>

<hr color="red" width="80%" align="left">

<form action="<%=request.getContextPath()%>/CollegesServlet" method="post">

    <input type="hidden" name="requestMethod" value="update">

    <table border="1" cellspacing="0" cellpadding="0" width="80%">
        <thead>

        </thead>
        <tbody>
            <tr>
                <td>ID</td><td><input type="text" name="collegeId" value="${colleges.collegeId}" readonly></td>
            </tr>
            <tr>
                <td>校名</td><td><input type="text" name="name" value="${colleges.name}"></td>
            </tr>
            <tr>
                <td>代码</td><td><input type="schoolCode" name="schoolCode" value="${colleges.schoolCode}" ></td>
            </tr>
            <tr>
                <td>主管</td><td><input type="text" name="department" value="${colleges.department}" ></td>
            </tr>
            <tr>
                <td>城市</td><td><input type="text" name="location" value="${colleges.location}" ></td>
            </tr>
            <tr>
                <td>地址</td><td><input type="text" name="address" value="${colleges.address}"></td>
            </tr>
            <tr>
                <td>层次</td><td><input type="text" name="educationLevel" value="${colleges.educationLevel}"></td>
            </tr>
            <tr>
                <td>联系</td><td><input type="text" name="contactInfo" value="${colleges.contactInfo}"></td>
            </tr>
            <tr>
                <td>备注</td><td><input type="text" name="remarks" value="${colleges.remarks}" ></td>
            </tr>
            <tr>
                <td><input type="reset" value="重置"></td><td><input type="submit" value="更新"></td>
            </tr>
        </tbody>
        <tfoot>

        </tfoot>
    </table>

</form>

</body>
</html>