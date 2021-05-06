<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 조회</title>
<style>
	#writeBtn{
		float:right;
		margin-right:20px;
	}
</style>
</head>
<body>
<jsp:include page="../header.jsp"/><br>
<div class="container-fluid">
	<h1>게시글 조회</h1><hr>
	<a data-toggle="modal" href="#writeModal" class="btn btn-primary" id="writeBtn">글쓰기</a>
</div>
<!-- 글쓰기 모달 -->
<div class="modal" id="writeModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- 모달 헤더 -->
			<div class="modal-header">
				<h4 class="modal-title">글쓰기</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<!-- 모달 바디 -->
			<div class="modal-body">
				<form action="write" method="post">
					<input type="hidden" id="write" name="writer" value="${pageContext['request'].userPrincipal.name}"/>
					<div class="form-group">
						<label for="title">제목 : </label>
						<input class="form-control" type="text" id="title" name="title"/>
					</div>
					<div class="form-group">
						<label for="content">내용 : </label>
						<textarea class="form-control" rows="5" id="content" name="content"></textarea>
					</div>
					<hr>
					<button type="submit" class="btn btn-primary">등록하기</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>			
				</form>
			</div>	
		</div>
	</div>
</div>
</body>
</html>