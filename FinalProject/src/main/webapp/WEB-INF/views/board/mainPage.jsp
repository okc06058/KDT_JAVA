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
	<c:choose>
		<c:when test="${!empty sessionUserInfo}">
			${sessionUserInfo.nickname} 님 환영합니다.
			<a href="../user/logoutProcess">로그아웃</a>
		</c:when>
		<c:otherwise>
			비회원 입니다.
			<a href="../user/loginPage">로그인</a>
		</c:otherwise>
	</c:choose>
	
	<br>
	<h1> 게시판 </h1>
	<table border="1">
		<tr>
			<td>글 번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>작성일</td>
		</tr>
		<c:forEach items="${list }" var="map">
			<tr>
				<td>${map.freeboardArticleDto.id}</td>
				<td>${map.freeboardArticleDto.title}</td>
				<td>${map.userDto.nickname}</td>
				<td>${map.freeboardArticleDto.read_count}</td>
				<td>${map.freeboardArticleDto.created_at}</td>
			</tr>		
		</c:forEach>	
		<tr>
		
		</tr>
	</table>
	
	<br>
	<br>
	<c:if test="${!empty sessionUserInfo}">
		<a href="./writeArticlePage">글쓰기</a>
	</c:if>
</body>
</html>