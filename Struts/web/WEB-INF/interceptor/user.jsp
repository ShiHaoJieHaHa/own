<%--
  Created by IntelliJ IDEA.
  User: ShiHaoJie
  Date: 2021/3/15
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.getSession().setAttribute("user", "zhangsan");
%>
<html>
<head>
    <title>消息页面</title>
</head>
<body>
该用户已经登陆
</body>
</html>
