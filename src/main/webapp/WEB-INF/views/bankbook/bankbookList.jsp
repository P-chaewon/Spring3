<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<c:import url="../temp/boot_head.jsp"></c:import>	
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
<div class="container-fluid">
	<div class="col-md-7 my-2 mx-auto">
		<table class="table table-hover">
			<tr>
				<th>Number</th><th>Name</th><th>Rate</th>
			</tr>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bookNum}</td>
				<td><a href="./bankbookSelect?bookNum=${dto.bookNum}">${dto.bookName}</a></td>
				<td>${dto.bookRate}</td>
			</tr>
			</c:forEach>
		</table>
		<a href="./bankbookInsert" class="btn btn-danger">ADD</a>
	</div>
</div>
</body>
</html>