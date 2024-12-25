<%--
  Created by IntelliJ IDEA.
  User: 11706
  Date: 2024/12/25
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>header</title>
</head>
<body>
欢迎${ loginUser.username } 登录就业数据填报管理系统 , <span style="float: right"><a target="_parent" href="<%=request.getContextPath()%>/LoginServlet?requestMethod=logout">退出</a></span>
</body>
</html>