
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>students</title>
</head>
<body>
<c:forEach items="${students}" var="student">
    id---${student.sid}<br>
    name---${student.sname}<br>
</c:forEach>
</body>
</html>
