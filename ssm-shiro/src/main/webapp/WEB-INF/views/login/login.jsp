<%--
  Created by IntelliJ IDEA.
  User: swg
  Date: 2017/11/24
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: left;border-color: grey;">
    <h3>登陆</h3>
    <form action="/login/doLogin" method="post">
        username:<input name="username" /><br><br>
        password:<input type="password" name="password" /><br><br>
        <input type="submit" value="submit"/>
    </form>
</div>
</body>
</html>
