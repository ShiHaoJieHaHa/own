<%--
  Created by IntelliJ IDEA.
  User: swg
  Date: 2017/11/24
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${users}" var="user">
    id---${user.id}<br>
    name---${user.name}<br>
</c:forEach>
</body>
</html>
