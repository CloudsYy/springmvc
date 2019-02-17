<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/demo.css" />
    <link rel="stylesheet" href="css/templatemo-style.css">
    <link href="css1/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <link href="css1/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            var nameElements = document.getElementById("username");
            nameElements.onblur = function () {
                var name = this.value;
                var reg = /^[\u4e00-\u9fa5a-z\d_]{1,6}$/gi;
                var replaceReg = /[^\x00-\xff]/;
                var len = name.replace(replaceReg,"aa").length;
                var req = getXMLHttpRequest();
                req.open("post","${pageContext.request.contextPath }/regisitered.action?username="+name);
                req.onreadystatechange = function () {
                    if(req.readyState==4){
                        if (req.status == 200){
                            var msg = document.getElementById("msg");
                            if (reg.test(name)==false||(len>12||len<2)){
                                msg.innerHTML="<font color='yellow'>用户名只能包含为1到6个中文字符，2到6个英文字符数字和下划线！</font>";
                            }else{
                                var reqq=trim(req.responseText);
                                if(reqq=="true"){
                                    msg.innerHTML="<font color='red'>该用户已注册</font>";
                                }else{
                                    msg.innerHTML="<font color='green'>可以使用</font>";
                                }
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

<span class="error-box" id="msg">${error2}
</span><br/>
<form action="${pageContext.request.contextPath }/regisitered.action" method="post">
    <div class="fm-item">
        <label class="form-label">用户账号：</label>
            <input type="text" name="username" id="username"/>
        <div class="ui-form-explain"></div>
    </div>
    <div class="fm-item">
        <label class="form-label">用户密码：</label>
           <input type="password" name="password" /><br/>
        <div class="ui-form-explain"></div>
    </div>
<input type="submit" style="color: #1c7430" class="btn-register" value="注册"/>
</form>
        </div>
    </div>
</div>

</body>
</html>