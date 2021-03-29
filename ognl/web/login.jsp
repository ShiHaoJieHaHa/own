<%--
  Created by IntelliJ IDEA.
  User: ShiHaoJie
  Date: 2021/3/29
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>OGNL的Map写法</title>
</head>
<body>
<!--  map!-->
<br>
<s:set name="map"
       value="#{'1':'eeeee','2':'ddddd','3':'ccccc','4':'bbbbb','5':'aaaaa'}"></s:set>
<s:iterator value="#map" var="o">
    ${o.key}->${o.value}<br/>
    <!--    <s:property value="#o.key"/>-><s:property value="#o.value"/><br/>   -->
    <!--    <s:property value="key" />-><s:property value="value" /> -->
</s:iterator>
<br/>
<hr>
</body>
</html>
