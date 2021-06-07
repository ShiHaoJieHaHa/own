<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ShiHaoJie
  Date: 2021/2/26
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>输出信息</title>
</head>
<body>
<s:property value="name"></s:property>
<br> <%=new Date() %>
</body>
</html>
