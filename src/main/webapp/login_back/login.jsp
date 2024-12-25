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
  <title>login</title>
</head>
<body>
<br><br><br><br><br><br>

${errorMessage}

<form action="<%=request.getContextPath()%>/LoginServlet" action="post">

  <input type="hidden" name="requestMethod" value="doLogin">

  <table border="1"  cellpadding="0" cellspacing="0" align="center">
    <thead></thead>
    <tbody>
    <tr>
      <td>用户名</td><td><input type="text" name="username"></td>
    </tr>
    <tr>
      <td>密码</td><td><input type="password" name="passwordHash"></td>
    </tr>
    <tr>
      <td><input type="reset"></td><td><input type="submit" value="登录"></td>
    </tr>
    </tbody>
    <tfoot></tfoot>
  </table>

</form>


</body>
</html>
