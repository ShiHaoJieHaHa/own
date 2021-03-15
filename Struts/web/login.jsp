<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>输入校验</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
  </head>
  
  <body>
   <s:fielderror/>
   <form action="${pageContext.request.contextPath}/personal/validate_update.action" method="post">
   		用户名:<input type="text" name="username"/>不能为空<br/>
   		手机号:<input type="text" name="mobile"/>不能为空,并且要符合手机号的格式1,3/5/8,后面是9个数字<br/>
   		<input type="submit" value="提交"/></form>
  </body>
</html>
