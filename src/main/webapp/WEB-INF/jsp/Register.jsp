<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>系统注册</title>
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
	<script type="text/javascript">
        window.onload = function () {
            var nameElements = document.getElementById("username");
            nameElements.onblur = function () {
                var name = this.value;
                alert(name);
                var req = getXMLHttpRequest();
                req.open("post","${pageContext.request.contextPath }/regisitered.action?username="+name);
                req.onreadystatechange = function () {
                    if(req.readyState==4){
                        if (req.status == 200){
                            var reqq=trim(req.responseText);
                            alert(reqq);
                            var msg = document.getElementById("msg");
                            if(reqq=="true"){
                                msg.innerHTML="<font color='red'>该用户已注册</font>";
                            }else{
                                msg.innerHTML="<font color='green'>可以使用</font>";
                            }
                        }
                    }
                }
                req.send(null);
            }
        }
        function getXMLHttpRequest(){
            var xmlhttp;
            if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            } else {// code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            return xmlhttp;
        }
        function trim(str){
            return str.replace(/^\s*|\s*$/g,"");
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

						<span id="msg">${allerrors}</span>

						<form class="registerform" action="${pageContext.request.contextPath }/regisitered.action" method="post">
							<div class="fm-item">
								<label class="form-label">用户账号：</label>
								<input type="text" placeholder="请输入账号" name="username">
								<div class="ui-form-explain"></div>
							</div>

							<div class="fm-item">
								<label class="form-label">用户密码：</label>
								<input type="password" name="password" placeholder="请输入密码">
								<div class="ui-form-explain"></div>
							</div>

							<div>
								<input type="submit" style="color: #1c7430" class="btn-register" value="注册">
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