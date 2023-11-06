<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 수정</h1>
	
	<form action="./updateArticleProcess" method="post">
		작성자: ${sessionUserInfo.nickname }<br>
		제목: <input name="title" type="text" value="${qwer.freeboardArticleDto.title }"><br>
		내용: <br>
		<textarea name="content" rows="10" cols="60">${qwer.freeboardArticleDto.content }</textarea>
		<br>
		
		<input name="id" type="hidden" value="${qwer.freeboardArticleDto.id }">
		
		<input type="submit" value="글 수정"> 	
	</form>
</body>
</html>
