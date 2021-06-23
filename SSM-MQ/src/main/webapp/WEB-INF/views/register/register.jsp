<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/includes.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Registration Page</title>
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
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="../../index2.html"><b>注册</b></a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">蜗牛生活</p>

        <form action="/register/regist" method="post" id="registerFrom">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="用户名" name="username" id="username">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                <span id="username_alert" style="color: red;visibility: hidden">用户名不能为空</span>
            </div>
            <div class="form-group has-feedback">
                <input type="email" class="form-control" placeholder="邮箱" name="email" id="email">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                <span id="email_alert" style="color: red;visibility: hidden">邮箱已存在</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span id="email_style_alert" style="color: red;visibility: hidden">邮箱格式不正确</span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="密码" name="password" id="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                <span id="password_alert" style="color: red;visibility: hidden">密码不能为空</span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="确认密码" name="rePassword" id="rePassword">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                <span id="rePassword_alert" style="color: red;visibility: hidden">密码不一致</span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="手机号码" name="phoneNumber" id="phoneNumber">
                <span class="glyphicon glyphicon-phone form-control-feedback"></span>
                <span id="phoneNumber_alert" style="color: red;visibility: hidden">手机号码不能为空</span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="button" class="btn btn-primary btn-block btn-flat" onclick="submitForm();" id="submitBtn">立即注册</button>
                </div>
                <div class="col-xs-12"> <span id="register_error" style="color: red;visibility: hidden">注册失败</span></div>
                <!-- /.col -->
            </div>
        </form>
        <a href="${pageContext.request.contextPath}/login" class="text-center">已有帐号，立即登陆</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.3 -->
<script src="/static/jquery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/static/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function(){
        verify = false;
        checkEmail();
    });

    function checkEmail(){
        $('#email').focusout(function(){
            var email = $(this).val();
            var param="${pageContext.request.contextPath}/register/checkEmail?email="+email+"";
            $.ajax({
                async:false,
                url:param,
                type:"POST",
                dataType:"json",
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',//防止乱码
                success:function(data){
                    if(data.code == 400){
                        $("#email_alert").css("visibility","visible");
                        $("#email_style_alert").css("visibility", "hidden");
                        verify = false;
                    }else{
                        $("#email_alert").css("visibility","hidden");
                        verify=true;
                    }
                }
            });
        });
    }
    function submitForm() {
        var flag = true;
        var username = $("#username").val();
        var email = $("#email").val();
        var password = $("#password").val();
        var rePassword = $("#rePassword").val();
        var phoneNumber = $("#phoneNumber").val();
        if(username.length==0){
            $("#username_alert").css("visibility","visible");
            flag=false;
        }else {
            $("#username_alert").css("visibility","hidden");
        }

        if(email.length==0){
            $("#register_error").css("visibility","visible");
            flag=false;
        }else {
            var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
            if(!reg.test(email)){
                $("#email_style_alert").css("visibility","visible");
                flag=false;
            }else {
                $("#email_style_alert").css("visibility", "hidden");
                $("#register_error").css("visibility","hidden");
            }
        }

        if(password.length==0){
            $("#password_alert").css("visibility","visible");
            flag=false;
        }else {
            $("#password_alert").css("visibility","hidden");
        }

        if(rePassword.length==0){
            flag=false;
        }else {
            if(rePassword!=password){
                $("#rePassword_alert").css("visibility","visible");
                flag=false;
            }else{
                $("#rePassword_alert").css("visibility","hidden");
            }
        }

        if(phoneNumber.length==0){
            $("#phoneNumber_alert").css("visibility","visible");
            flag=false;
        }else {
            $("#phoneNumber_alert").css("visibility","hidden");
        }
        if(verify==true&&flag==true){
            $("#submitBtn").attr("disabled", "disabled").text("提交中...");
            $("#registerFrom").submit();
        }else {
            $("#register_error").css("visibility","visible");
        }
    };
</script>
</body>
</html>

