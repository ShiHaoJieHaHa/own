<%--
  Created by IntelliJ IDEA.
  User: ShiHaoJie
  Date: 2021/6/7
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<s:form action="postToken" namespace="/token" method="post">
   姓名:<s:textfield name="name"/><br/><s:token></s:token>
    <input type="submit" value="提交">
</s:form>
</body>
</html>
