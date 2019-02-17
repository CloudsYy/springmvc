<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
    function login() {
        document.userForm.action="${pageContext.request.contextPath }/login.action";
        document.userForm.submit();
    }
    function reg() {
        document.userForm.action="${pageContext.request.contextPath }/valid.action";
        document.userForm.submit();
    }
</script>
<title>系统登陆</title>
</head>
<body>
<p>${error1}</p>
<form name="userForm" method="post">
用户账号：<input type="text" name="username" /><br/>
用户密码 ：<input type="password" name="password" /><br/>
<input type="button" value="登陆" onclick="login()"/>
<input type="button" value="注册" onclick="reg()">
</form>
</body>
</html>