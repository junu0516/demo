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
	<h1>수정하기</h1><hr>
</div>
<br><br><br>
<div class="container">
	<form>
		<table class="table table-hover" id="formData">
			<tr>
		    	<th>제목</th>
		        <th colspan="3"><input type="text" id="title" name="title" value="${board.title}"/></th>
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
		    	<td colspan="4"><textarea class="form-control" rows="5" id="content" name="content">${board.content}</textarea></td>
		    </tr>
		</table>
	</form>
	<button class="btn btn-primary" onclick="formSubmit(${board.no});">수정하기</button>
</div>

<script>
	function formSubmit(no){
		console.log("debug");
		
		var putUrl = "/board/"+no;
		var title = $("#title").val();
		var content = $("#content").val();
		
		$.ajax({
			type:"put",
			url:putUrl,
			data:{
				title:title,
				content:content
			},
			success:function(result){
				alert("수정 성공");
				location.href="/board/detail?no="+no;
			},
			error:function(e){
				alert("수정 실패\n"+e);
			}
		});
	}	
</script>

</body>
</html>