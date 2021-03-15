<%--
  Created by IntelliJ IDEA.
  User: ShiHaoJie
  Date: 2021/3/15
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.getSession().removeAttribute("user");
%>
<html>
<head>
    <title>退出页面</title>
</head>
<body>
该用户已经退出登陆了
</body>
</html>
