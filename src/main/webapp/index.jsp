<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>index.jsp</title>
  <jsp:include page="/include/bs5.jsp" />
  <script>
    //location.href = "/mvcTest05/boardList";
  </script>
</head>
<body>
<p><br/></p>
<div class="container">
  <h2>선택해 주세요.</h2>
  <p>
    <a href="/mvcTest05/boardList" class="btn btn-success mt-4 me-4">게시판 연습</a>
    <a href="/mvcTest05/mapping" class="btn btn-primary mt-4">매핑(확장자패턴) 연습</a>
  </p>
</div>
</body>
</html>