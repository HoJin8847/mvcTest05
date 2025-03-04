<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<% pageContext.setAttribute("newLine","/n"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>boardContent.jsp</title>
	<jsp:include page="/include/bs5.jsp"></jsp:include> <!-- 액션으로 include -->

	<script>
		'use Strict'; //변수를 선언하지 않으면 에러가 남
	
		function delCheck(){
			let ans = confirm("현재 게시글을 삭제하시겠습니가?");
			if(ans) location.href = "boardDelete?idx=${vo.idx}";
		}
	</script>	
</head>
<body>
<p><br></p>
<div class="container">
	<h2 class="text-center">게시판 상세보기</h2>
	<table class="table table-bordered">
		<tr>
			<th class="text-center align-middle bg-body-secondary">글쓴이</th><td>${vo.name}</td>
			<th class="text-center align-middle bg-body-secondary">글쓴날짜</th><td>${vo.wDate}</td>
		</tr>
		<tr>
			<th class="text-center align-middle bg-body-secondary">조회수</th><td>${vo.readNum}</td>
			<th class="text-center align-middle bg-body-secondary">접속IP</th><td>${vo.hostIP}</td>
		</tr>
		<tr>
			<th class="text-center align-middle bg-body-secondary">글제목</th><td colspan="3">${vo.title}</td>
		</tr>
		<tr>
			<th class="text-center align-middle bg-body-secondary" style="height:400px">글내용</th><td colspan="3">${fn:replace(vo.content, newLine, "<br/>")}</td>
		</tr>
	</table>
	<br/>
	<div>
		<a href="boardList" class="btn btn-warning">돌아가기</a>
		<a href="javascript:delCheck()" class="btn btn-danger">삭제</a>
	</div>
</div>
</body>
</html>