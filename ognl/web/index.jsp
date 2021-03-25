<%--
  Created by IntelliJ IDEA.
  User: ShiHaoJie
  Date: 2021/3/25
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
  request.setAttribute("user","zhangsan");
  request.getSession().setAttribute("name","xiaoming");
%>
<html>
  <head>
    <title>ognl表达式</title>
  </head>
  <body>
  <!--获取request范围里的数据 !-->
  <s:property value="#request.user"/> <br>
  <s:property value="#session.name"/>
  </body>
</html>
