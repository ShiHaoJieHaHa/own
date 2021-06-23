<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/includes.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>提示</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/static/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <!-- jQuery 2.2.3 -->
    <script src="/static/jquery/jquery-2.2.3.min.js"></script>
</head>
<body class="hold-transition lockscreen">
<!-- Automatic element centering -->
<div class="lockscreen-wrapper">
    <div class="lockscreen-logo">
        <a href="../../index2.html"><b>蜗牛生活</b></a>
    </div>
    <div class="lockscreen-name">不要调皮，您已经注册了！</div>
    <div>
        <a href="${pageContext.request.contextPath}/login"><span id="time">5</span>秒后系统会自动跳转到登陆页面，也可点击本处直接跳转哦</a>
        <script type="text/javascript">
            $(document).ready(function(){
                delayURL("${pageContext.request.contextPath}/login");
            })

            function delayURL(url) {
                var delay = document.getElementById("time").innerHTML;
                if (delay > 0) {
                    delay--;
                    document.getElementById("time").innerHTML = delay
                } else {
                    window.top.location.href = url
                }
                setTimeout("delayURL('" + url + "')", 1000)
            }
        </script>
    </div>
</div>
<!-- /.center -->
</body>
</html>
