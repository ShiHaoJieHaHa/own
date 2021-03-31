<%--
  Created by IntelliJ IDEA.
  User: ShiHaoJie
  Date: 2021/3/31
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>ognl投影的功能</title>
</head>
<body>
<s:iterator value="list.{?#this.price>60}">
    <s:property value="name"/>,价格:<s:property value="price"/><br>
</s:iterator>
</body>
</html>
