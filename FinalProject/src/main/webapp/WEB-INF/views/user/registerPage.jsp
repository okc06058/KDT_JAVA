<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입</h1>
	<form action="./registerProcess" method="get">
		ID: <input name="userid" type="text"><br>
		PW: <input name="password" type="password"><br>
		닉네임: <input name="nickname" type="text"></br>
		이메일: <input name="email" type="text"></br>
		성별:
		<input name="gender" type="radio" value="M">남
		<input name="gender" type="radio" value="F">여
		</br>
		생년월일: <input name="birth" type="date"></br>
		전화번호: <input name="phone" type="text"></br>
		
		<input type="submit" value="회원가입">
	</form>
</body>
</html>