<%@ page language="java" import="java.util.*,com.etc.pojo.*" pageEncoding="ISO-8859-1"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personalinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 <%Customer cust=(Customer)request.getAttribute("cust"); %>
 Your Personal Info:<br>
 Name:<%=cust.getCustname() %><br>
 Password:<%=cust.getPwd() %><br>
 Age:<%=cust.getAge() %><br>
 Address:<%=cust.getAddress() %><br>
  </body>
</html>
