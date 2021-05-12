<%@ page language="java" import="java.util.*,com.etc.pojo.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allusers.jsp' starting page</title>
    
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
<%List<Customer> list=(List<Customer>)request.getAttribute("allcustomers");%>
 所有用户信信息:<br>
<table width="200" border="1">
<tbody>
	<tr>
	<td>&nbsp;用户名</td>
	<td>&nbsp;年龄</td>
	<td>&nbsp;地址</td>
	</tr>
	<%for(Customer c:list){ %>
	<tr>
	<td><%=c.getCustname() %></td>
	<td><%=c.getAge() %></td>
	<td><%=c.getAddress() %></td>
	</tr>
	<%}%>
</tbody></table><br>
  </body>
</html>
