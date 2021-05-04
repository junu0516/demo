<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Form</h1>
	<form id="loginForm" method="post" action="login">
		<label for="userId">아이디 : </label>
		<input type="text" id="userId" name="userId"/><br>
		<label for="userPwd">비밀번호 : </label>
		<input type="password" id="userPwd" name="userPwd"/><br>
		<button type="submit">로그인</button>
	</form>
</body>
</html>