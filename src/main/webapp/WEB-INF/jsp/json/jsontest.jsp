<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        function requestJson() {
            $.ajax({
                type:"post",//页面action
                url:'${pageContext.request.contextPath}/requestJson.action',
                contentType:"application/json;charset-utf-8",
                //json格式串
                data:'{"name":"手机"}，{"price":999}',
                success:function (data) {
                       alert(data);
                   }
            });
        }

        function responseJson() {
            $.ajax({
                type:"post",//页面action
                url:'${pageContext.request.contextPath}/requestJson.action',
                contentType:"application/json;charset-utf-8",
                //输出key/value
                data:'name=手机&price=330.0',
                success:function (data) {
                    alert(data);
                }
            });
        }

    </script>
    <title>Jsontest</title>
</head>
<body>
</body>

</html>