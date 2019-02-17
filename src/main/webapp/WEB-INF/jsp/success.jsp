<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>操作成功</title>
</head>
<br>
注册成功，请返回登录页面！<br/>
<form action="${pageContext.request.contextPath }/queryItems.action" method="post">
    <input type="submit" value="返回登录页面">
</form>
</body>
</html>