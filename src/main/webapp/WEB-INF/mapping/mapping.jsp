<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>mapping.jsp</title>
	<jsp:include page="/include/bs5.jsp"/>
</head>
<body>
<p><br></p>
<div class="container">
	<h2>확장자 패턴 연습하기</h2>
	<div class="row mt-3">
		<div class="col"><a href="boardList.do" class="btn btn-success">게시판리스트</a></div> <!-- href 에서 do는 controller로 가고 앞에 나와있는애는 무조건 controller까지는 가되, 그걸로 분류해서 각각 다른데로 감 -->
		<div class="col"><a href="boardInput.do" class="btn btn-primary">게시판입력</a></div> 
		<div class="col"><a href="boardUpdate.do" class="btn btn-secondary">게시판수정</a></div> 
		<div class="col"><a href="boardDelete.do" class="btn btn-info">게시판삭제</a></div> 
	</div>
</div>
</body>
</html>