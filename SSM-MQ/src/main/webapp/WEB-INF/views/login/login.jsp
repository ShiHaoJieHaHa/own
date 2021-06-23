<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/includes.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登陆后台管理系统</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/static/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition login-page">

<div class="login-box">
    <div class="login-logo">
        <b>登陆系统</b>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">蜗牛生活</p>

        <div class="form-group has-feedback">
            <input id="email"  type="email" class="form-control" placeholder="邮箱">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            <span id="user_alert" style="color: red;visibility: hidden">请输入帐号</span>
        </div>
        <div class="form-group has-feedback">
            <input id="pwd" type="password" class="form-control" placeholder="密码">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            <span id="pwd_alert" style="color: red;visibility: hidden">请输入密码</span>
        </div>
        <div class="row">
            <div class="col-xs-8" style="padding-left:35px;">
                <div class="checkbox icheck">
                    <label>

                    </label>
                </div>
            </div>
            <!-- /.col -->
            <div class="col-xs-4">
                <button id="submitId" type="button" class="btn btn-primary btn-block btn-flat">登录</button>
            </div>
            <div class="col-xs-12"> <span id="login_error" style="color: red;visibility: hidden">登陆失败，请检查账号密码以及是否已经激活</span></div>

            <!-- /.col -->
        </div>
        <a href="${pageContext.request.contextPath}/register" class="text-center">木有帐号，立即注册</a>




    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="/static/jquery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/static/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $("#submitId").click(function () {
            var email=$("#email").val();
            var pwd=$("#pwd").val();
            var veryfiy=true;
            if(email.length==0){
                $("#user_alert").css("visibility","visible");
                veryfiy=false;
            }else {
                $("#user_alert").css("visibility","hidden");
            }
            if(pwd.length==0){
                $("#pwd_alert").css("visibility","visible");
                veryfiy=false;
            }else {
                $("#pwd_alert").css("visibility","hidden");
            }
            if(veryfiy){
                $("#loginForm").submit();
                //ajax提交表单
                $.ajax({
                    type:"POST",
                    url:"/login/check",
                    data:{"email":email,"password":pwd},
                    success:function (data) {
                        var result = JSON.parse(data);
                        if(result.code==200){
                            window.location.href="/login/loginSucc";
                        }else{
                            $("#login_error").css("visibility","visible");
                        }
                    }
                });
            }
        });
    });
</script>
</body>
</html>
