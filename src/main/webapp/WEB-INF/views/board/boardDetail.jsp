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
	#pagination{
		float:right;
		margin-right:40%;
	}
</style>
</head>
<body>
<jsp:include page="../header.jsp"/><br>
<div class="container-fluid">
	<h1>게시글 상세조회</h1><hr>
</div>
<br><br><br>
<div class="container">
	<table class="table table-hover" id="boardDetail">
	    	<tr>
	        	<th>제목</th>
	        	<th colspan="3">${board.title}</th>
	      	</tr>
	      	<tr>
	      		<th>작성자</th>
	      		<td>${board.writer}</td>
	      		<td>조회수</td>
	      		<td>${board.count}</td>
	      	</tr>
	      	<tr>
	      		<th>작성일자</th>
	      		<td>${board.createDate}</td>
	      		<th>수정일자</th>
	      		<td>${board.modifyDate}</td>
	      	</tr>
	      	<tr>
	      		<td colspan="4">${board.content}</td>
	      	</tr>
	</table>
	<hr>
	<a class="btn btn-primary" href="/board/list">목록으로</a>
	<c:if test="${pageContext['request'].userPrincipal.name eq board.writer}" >
	<a class="btn btn-secondary" href="/board/modify?no=${board.no}">수정하기</a>
	<button class="btn btn-danger" onclick="deleteBoard(${board.no});">삭제하기</button>		
	</c:if>
</div>

<script>
	function deleteBoard(no){
		
		var deleteUrl = "/board/"+no;
		var deleteData = {"no":no};
		
		$.ajax({
			type:"delete",
			url:deleteUrl,
			data:deleteData,
			success:function(result){
				alert("삭제 성공");
				location.href="/board/list";
			},error:function(e){
				alert("삭제 실패");
			}
		});
	}
</script>

</body>
</html>