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
	<h1>게시글 조회</h1><hr>
	<a data-toggle="modal" href="#writeModal" class="btn btn-primary" id="writeBtn">글쓰기</a>
</div>
<br><br><br>
<div class="container">
	<h2>목록 보기</h2><br>
	<table class="table table-hover" id="boardList">
		<thead>
	    	<tr>
	        	<th>번호</th>
	        	<th>제목</th>
	        	<th>작성자</th>
	        	<th>작성날짜</th>
	      	</tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${boards}" var="board">
	    	<tr>
	    		<td>${board.no}</td>
	    		<td>${board.title}</td>	    		
	    		<td>${board.writer}</td>
	    		<td>${board.createDate}</td>
	    	</tr>
	    	</c:forEach>
	    </tbody>	
	</table>
	<hr>
	<ul class="pagination" id="pagination">
		<c:choose>
			<c:when test="${pageInfo.currentPage ne 1}">
				<li class="page-item">
					<a class="page-link" href="/board/list?page=${pageInfo.currentPage-1}">Previous</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<a class="page-link" href="#">Previous</a>
				</li>
			</c:otherwise>
		</c:choose>
		<c:forEach begin="${pageInfo.startPage}" end="${pageInfo.endPage}" var="page">
			<c:choose>
				<c:when test="${pageInfo.currentPage ne page}">
					<li class="page-item">
						<a class="page-link" href="/board/list?page=${page}">${page}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item disabled">
						<a class="page-link" href="/board/list?page=${page}">${page}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${pageInfo.currentPage ne pageInfo.maxPage}">
				<li class="page-item">
					<a class="page-link" href="/board/list?page=${pageInfo.currentPage+1}">Next</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<a class="page-link" href="#">Next</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
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

<script>
	$(function(){
		$('#boardList tbody tr').click(function(){
			location.href="/board/detail?no="+$(this).children().eq(0).text();
		});
	});
	
</script>
</body>
</html>