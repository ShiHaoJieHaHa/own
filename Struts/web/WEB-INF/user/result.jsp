<%--
  Created by IntelliJ IDEA.
  User: ShiHaoJie
  Date: 2021/3/5
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果页面</title>
</head>
<body>
<form action="/hello/getusermessage_execute" method="post">
    id<input type="text" name="person.id"><br>
    name<input type="text" name="person.name"><br>
    <input type="submit" value="发送">
</form>
</body>
</html>
