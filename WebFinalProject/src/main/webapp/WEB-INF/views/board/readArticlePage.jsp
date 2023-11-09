<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글</h1>
	
	제목: ${qwer.freeboardArticleDto.title }<br>
	작성자: ${qwer.userDto.nickname }<br>
	조회수: ${qwer.freeboardArticleDto.read_count }<br>
	내용: <br>
	${qwer.freeboardArticleDto.content }<br>
	
	<br><br>
	
	<a href="./mainPage">목록으로</a>
	
	<c:if test="${!empty sessionUserInfo && sessionUserInfo.id == qwer.freeboardArticleDto.user_id }">
		<a href="./deleteArticleProcess?id=${qwer.freeboardArticleDto.id }">삭제</a>
		<a href="./updateArticlePage?id=${qwer.freeboardArticleDto.id }">수정</a>	
	</c:if>
	
</body>
</html>



