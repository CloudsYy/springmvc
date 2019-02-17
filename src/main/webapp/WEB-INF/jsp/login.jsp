<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>系统登录</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">  <!-- Google web font "Open Sans" -->
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  
  <link rel="stylesheet" href="css/demo.css" />
  <link rel="stylesheet" href="css/templatemo-style.css">
	<link href="css1/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
	<link href="css1/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="js/jquery1.42.min.js"></script>
	<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
	<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>
  
  <script type="text/javascript" src="js/modernizr.custom.86080.js"></script>
	<script>
        $(function(){

            $(".i-text").focus(function(){
                $(this).addClass('h-light');
            });

            $(".i-text").focusout(function(){
                $(this).removeClass('h-light');
            });

            $("#username").focus(function(){
                var username = $(this).val();
                if(username=='输入账号'){
                    $(this).val('');
                }
            });

            $("#username").focusout(function(){
                var username = $(this).val();
                if(username==''){
                    $(this).val('输入账号');
                }
            });


            $("#password").focus(function(){
                var username = $(this).val();
                if(username=='输入密码'){
                    $(this).val('');
                }
            });


            $(".registerform").Validform({
                tiptype:function(msg,o,cssctl){
                    var objtip=$(".error-box");
                    cssctl(objtip,o.type);
                    objtip.text(msg);
                },
                ajaxPost:true
            });
        });

        function login() {
            document.userForm.action="${pageContext.request.contextPath }/login.action";
            document.userForm.submit();
        }
        function reg() {
            document.userForm.action="${pageContext.request.contextPath }/valid.action";
            document.userForm.submit();
        }
	</script>
		
	</head>
	<body>
			<div id="particles-js"></div>

			<ul class="cb-slideshow">
	            <li></li>
	            <li></li>
	            <li></li>
	            <li></li>
	            <li></li>
	            <li></li>
	        </ul>

			<div class="banner">
				<div class="login-aside">
					<div id="o-box-up"></div>
					<div id="o-box-down"  style="table-layout:fixed;">
						<div class="error-box">${error1}</div>

						<form class="registerform" name="userForm" method="post">
							<div class="fm-item">
								<label class="form-label">系统登录：</label>
								<input type="text" maxlength="100" placeholder="请输入账号" id="username" name="username" class="i-text"  datatype="*2-10" nullmsg="用户名不能为空" errormsg="用户名至少2个字符,最多10个字符！"  >
								<div class="ui-form-explain"></div>
							</div>

							<div class="fm-item">
								<label class="form-label">登录密码：</label>
								<input type="password" value="" maxlength="100" id="password"  name="password" class="i-text" datatype="*4-16" nullmsg="请设置密码！" errormsg="密码范围在4~16位之间！">
								<div class="ui-form-explain"></div>
							</div>

							<div class="fm-item">
								<label class="form-label"></label>
								<input type="button" value="" tabindex="4" id="send-btn" class="btn-login" onclick="login()">
								<div class="ui-form-explain"></div>
							</div>

							<div>
								<input type="button" value="注册" class="btn-reg" onclick="reg()">
							</div>
						</form>

					</div>

				</div>
			</div>
			<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>

	</body>
	<script type="text/javascript" src="js/particles.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</html>