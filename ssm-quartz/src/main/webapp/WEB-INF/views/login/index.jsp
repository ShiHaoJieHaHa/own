<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>您好${loginUser.username}</h2>
<a href="/user/user">普通用户和管理员都能看的页面</a><br><br>
<a href="/user/admin">管理员用户能看的页面</a><br><br>
<a href="/user/logout">退出</a>
</body>
</html>
