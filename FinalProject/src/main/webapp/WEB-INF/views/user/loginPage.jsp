<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="./loginProcess" method="get">
		ID: <input name="userid" type="text"><br>
		PW: <input name="password" type="password"><br>
	<input type="submit" value="로그인">
	</form>
	<a href="./registerPage">회원가입</a>
	
</body>
</html>