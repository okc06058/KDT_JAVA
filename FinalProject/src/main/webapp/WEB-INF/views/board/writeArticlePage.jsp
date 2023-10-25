<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 쓰기</h1>
	
	<form action="./writeArticleProcess" method="post">
		작성자: ${sessionUserInfo.nickname }<br>
		제목: <input name="title" type="text"><br>
		내용: <br>
		<textarea name="content" row="10" cols="60"></textarea>
		<br>
		<input type="submit" value="글 작성">
	</form>
</body>
</html>