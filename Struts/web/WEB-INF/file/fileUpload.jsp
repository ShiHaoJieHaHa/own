<%--
  Created by IntelliJ IDEA.
  User: ShiHaoJie
  Date: 2021/3/12
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/file/filelist_execute.action" enctype="multipart/form-data" method="post">
    文件:<input type="file" name="image">
    <input type="submit" value="上传"/>
</form>
</body>
</html>
