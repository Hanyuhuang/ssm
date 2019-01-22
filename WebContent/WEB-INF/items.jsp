<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品信息</title>
 <script type="text/javascript">
     function selectItem(){
    	 document.getElementById("itemForm").action="${pageContext.request.contextPath }/itemList.action";
    	 document.getElementById("itemForm").submit();
     }
     function deleteItem(){
    	 document.getElementById("itemForm").action="${pageContext.request.contextPath }/deleteItem.action";
    	 document.getElementById("itemForm").submit();
     }
 </script>
</head>

<body>
  <br/>
  <br/>
  <form id="itemForm" action="${pageContext.request.contextPath }/itemList.action" method="post">
  <table border="1">
      <tr>
      <td colspan="7">商品名称：<input type="text" name="name">
      <input type="button" value="查询" onclick="selectItem()">
      <input type="button" value="删除" onclick="deleteItem()">
      </td>
      </tr>
      <tr><td>选择</td><td>商品编号</td><td>商品名称</td><td>商品价格（元）</td><td>商品图片</td><td>商品细节</td><td>修改</td></tr>
      <c:forEach items="${list}" var="item">
          <tr>
          <td><input type="checkbox" name="id" value="${item.id}"></td>
          <td> ${item.id}</td>
          <td> ${item.name}</td>
          <td> ${item.price}</td>
          <td><img src="/pic/${item.pic}" height=50px width=50px /></td>
          <td> ${item.detail}</td>
          <td><a href="${pageContext.request.contextPath }/goUpdateItem.action?id=${item.id}">修改</a></td>
          </tr>
      </c:forEach>
  </table>
</form>
</body>
</html>