<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body>
  <br/>
  <br/>
	<form action="${pageContext.request.contextPath }/login.action"
		method="post">
		用户名<input type="text" name="name" style="margin-left:25px"><br/><br/>
		密 码<input type="password" name="password" style="margin-left:30px"><br/><br/>
		<c:if test="${error!=null}">
		    <font color="red" style="margin-left:20px"> ${error}</font>
		</c:if><br/><br/>
		 <input type="submit" value="登录" style="margin-left:50px">
	</form>
</body>
</html>