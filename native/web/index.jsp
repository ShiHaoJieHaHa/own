<%--
  Created by IntelliJ IDEA.
  User: ShiHaoJie
  Date: 2021/3/17
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
    <title>国际化</title>
  </head>
  <body>
  <s:text name="welcome"/> <br>
  <!-- 通过key属性指定资源文件的key方式 !-->
  <s:textfield name="shenzhou" key="welcome"/>
    -------------
  <!-- 编写好 使用jdk自带的native2asci命令转化编码 !-->
  </body>
</html>
