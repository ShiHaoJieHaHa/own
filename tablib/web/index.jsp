<%--
Created by IntelliJ IDEA.
User: ShiHaoJie
Date: 2021/4/1
Time: 11:05
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<s:set name="list" value="{'掌门','hangming','zhangsan'}"/>
<s:iterator value="#list" status="st">
    <font color=<s:if test="#st.odd">red</s:if> <s:else>blue</s:else>>
        <s:property></s:property></font><br>
</s:iterator>
-------------------<br>
<!--scope范围 !-->
<s:set name="age" value="232" scope="request"></s:set>
<s:if test="#request.age==23">
    23
</s:if>
<s:elseif test="#request.age==21">
    21
</s:elseif>
<s:else>
    都不是
</s:else>
<br/>
<s:url action="hello.action" namespace="/tablib">
    <s:param name="personid" value="#request.age"></s:param>
</s:url>
<br/>
<s:set name="myurl" value="'http://www.foshanshop.net'"/>
<s:url value="%{#myurl}"/><br>
<s:checkboxlist name="list" list="{'java','php','javaee','c#'}" value="{'java','javaee'}"></s:checkboxlist>
<br>
<s:checkboxlist name="map" list="#{1:'床上用品',2:'衣服',3:'鞋子',4:'裙子'}" listKey="key" listValue="value" value="{1,2,3}"/>
<br>
...................................... <br/>
<!-- 集合存放一个bean对象   list    listkey,listvalue取的都是bean的属性
 单选框   bean   map   list
 !-->
<%--  <s:radio name="beans"  list="#request.presons" listKey="presonid" listValue="name"></s:radio>--%>
<s:radio name="map" list="#{1:'床上用品',2:'衣服',3:'鞋子',4:'裙子'}" listKey="key" listValue="value" value="1"/><br>
<s:radio name="list" list="{'java','php','javaee','c#'}" value="java"/><br/>
<%-- 下拉框--%>
<s:select name="list" list="{'java','php','javaee','c#'}" value="java"></s:select> <br/>
<%--<s:select name="beans" list="#request.presons" listKey="personid" listValue="name"/>--%>
<s:select name="map" list="#{1:'床上用品',2:'衣服',3:'鞋子',4:'裙子'}" listKey="key"
listValue="value"  value="2"></s:select><br/>
</body>
</html>
