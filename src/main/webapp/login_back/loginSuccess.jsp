<%--
  Created by IntelliJ IDEA.
  User: 11706
  Date: 2024/12/25
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>loginSucces</title>
</head>

<frameset rows="50 , *">
  <frame src="<%=request.getContextPath()%>/LoginServlet?requestMethod=header">
  <frameset cols="150 , *">
    <frame src="<%=request.getContextPath()%>/LoginServlet?requestMethod=left">
    <frame src="<%=request.getContextPath()%>/LoginServlet?requestMethod=welcome" name="right">
  </frameset>

</frameset>


</html>