<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.container{
		display:flex;
		justify-content:center;
	}
</style>
</head>
<body>
<jsp:include page="../header.jsp"/><br><br><br>
	<h2 align="center">로그인</h2>
	<br><br><br>
	<div class="container center-block">
		<form action="login" method="post">
			<div class="form-inline" >
				<label for="userId">아이디 : </label>&nbsp&nbsp&nbsp&nbsp&nbsp
				<input class="form-control" type="text" id="userId" name="userId"/>
			</div>
			<br>
			<div class="form-inline">
				<label for="userPwd">비밀번호 : </label>&nbsp&nbsp
				<input class="form-control" type="password" id="userPwd" name="userPwd"/>
			</div>
			<br>				
			<button type="submit" class="btn btn-primary">로그인</button>
		</form>
	</div>
</body>
</html>