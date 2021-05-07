<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>员工列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
  </head>
  
  <body>
   ONGL:
   <br/>
   <s:iterator value="#request.employees">
   	<s:property value="username"/> ,<s:property value="password"/>, <s:property value="gender"/><br/>
   </s:iterator>
   
   <br/>
   
   <a href="<s:url action="manage_addUI" namespace="/employee"/>">员工添加</a>
   <br/>
   JSTL/EL:
   <br/>
   <c:forEach items="${employees}" var="employee">
   	${employee.username}, ${employee.password}, ${employee.gender}<br/>
   </c:forEach>
  </body>
</html>
