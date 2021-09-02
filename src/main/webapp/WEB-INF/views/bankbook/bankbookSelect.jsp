<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>Bankbook Select</h1>
	<div class="container-fluid">
		<h3>BookNum : ${dto.bookNum }</h3>
		<h3>BookName : ${dto.bookName}</h3>
		<h3>BookRate : ${dto.bookRate }</h3> 
	</div>
	<div class="mb3 ml-0">
			<a class="btn btn-danger" href="./bankbookDelete?bookNum=${dto.bookNum}">Delete</a>	
	</div>	
</body>
</html>