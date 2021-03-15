<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'employeeAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/file/filelistAll_execute.action" enctype="multipart/form-data" method="post">
    	文件1:<input type="file" name="image"><br/>
    	文件2:<input type="file" name="image"><br/>
    	文件3:<input type="file" name="image"><br/>
    	<input type="submit" value="上传"/>
    </form>
  </body>
</html>
