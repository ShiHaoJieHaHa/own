<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>员工添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
  </head>
  
  <body>
  	<s:form action="manage_add" namespace="/employee" method="post">
  		用户名:<s:textfield name="employee.username"/><br/>
  		密码:<s:textfield name="employee.password"/><br/>
  		性别:<s:radio list="#{'MAN':'男','WOMEN':'女'}" listKey="key" listValue="value" name="employee.gender"/>
  		<input type="submit" value="保存"/>
  	</s:form>
  </body>
</html>
