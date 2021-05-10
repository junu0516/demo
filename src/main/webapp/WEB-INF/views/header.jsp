<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<!-- 네비게이션 바 -->
<nav class="navbar navbar-expand-sm bg-light justify-content-center">
  <ul class="navbar-nav">
  	<li class="nav-item">
      <a class="nav-link" href="/main">홈으로</a>
    </li>
  	<sec:authentication var="principal" property="principal"/>
  	<c:if test="${pageContext['request'].userPrincipal.name != null}">
	<li class="nav-item">
      <a class="nav-link" href="/logout">로그아웃</a>
    </li>
  	</c:if>
    <c:if test="${pageContext['request'].userPrincipal.name == null }">
     <li class="nav-item">
      <a class="nav-link" data-toggle="modal" href="#enrollModal">회원가입</a>
    </li>
	<li class="nav-item">
      <a class="nav-link" href="/loginForm">로그인</a>
    </li>
	</c:if>
	<c:if test="${userId != null }">
    
	</c:if>
    <li class="nav-item">
      <a class="nav-link" href="/board/list">게시글 보기</a>
    </li>
  </ul>
</nav>

<!-- 회원가입 모달 -->
<div class="modal" id="enrollModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- 모달 헤더 -->
			<div class="modal-header">
				<h4 class="modal-title">회원가입</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			
			<!-- 모달 바디 -->
			<div class="modal-body">
				<form action="enroll" method="post">
					<div class="form-group">
						<label for="userId">아이디 : </label>&nbsp
						<input class="form-control" type="text" id="userId" name="id"/><br>
						<label for="userPwd">비밀번호 : </label>&nbsp
						<input class="form-control" type="password" id="userPwd" name="pwd"/><br>
						<label for="userName">이름 : </label>&nbsp
						<input class="form-control" type="text" id="userName" name="name"/>
					</div>				
					<hr>
					<button type="submit" class="btn btn-primary">가입하기</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
				</form>
			</div>
		</div>
	</div>
</div>


<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>