<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/updateItem.action"
		method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>商品编号</td>
				<td><input type="text" name="id" value="${item.id}"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" value="${item.name}"></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="${item.price}"></td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td><c:if test="${item.pic!=null&&item.pic!=''}">
						<img src="/pic/${item.pic}" height="100px" width="100px"/>
					</c:if> <input type="file" name="multipartFile"></td>
			</tr>
			<tr>
				<td>商品细节</td>
				<td><input type="text" name="detail" value="${item.detail}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="修改"></td>
			</tr>
		</table>
	</form>

</body>
</html>