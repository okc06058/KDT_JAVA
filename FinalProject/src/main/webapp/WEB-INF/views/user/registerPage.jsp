<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

	<script>
		function formSubmit(){
			const frm = document.getElementById("frm");
			
			const inputId = document.getElementById("inputId");
			
			const idRegex = /^[a-zA-Z][a-zA-Z0-9_]*$/;
			
			if(!idRegex.test(inputId.value)){
				alert("어쨌든 넌 안되..!! ... 제대로 표현");
				inputId.focus();	
				return ;
			}
			
			
			const inputPassword = document.getElementById("inputPassword");
			const passwordRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/
			if(!passwordRegex.test(inputPassword.value)){
				alert("비밀번호 제대로 써줘..정규표현 에러");
				inputPassword.value = "";
				inputPassword.focus();
				
				return;
			}
			
			const inputPasswordConfirm = document.getElementById("inputPasswordConfirm");
			
			if(inputPasswordConfirm.value != inputPassword.value){
				alert("비밀번호를 확인해 주세요!!?? 불일치 에러");
				inputPasswordConfirm.value = "";
				inputPassword.value = "";
				
				inputPassword.focus();
				
				return;
			}
			
			if(isCheckedId == false){
				alert("아이디 중복검사를 하셔야 됩니다.");
				return;
			}
			
			frm.submit();
		}
		
		function checkUserId(){
			const inputIdValue = document.getElementById("inputId").value;
			// alert(inputIdValue);
			
			// ES5
			// AJAX - Async.. Javascript And Xml - 비동기식 자바스크립트와 xml
			// 객체 생성
			const xhr = new XMLHttpRequest();
			
			// 세팅
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					// 여기가 실행되는 시점 = 서버로 부터 정상 응답 받았을때
					const response = JSON.parse(xhr.responseText);
					
					// 클라이언트 사이드 렌더링 시작(CSR)
					console.log(response.result);
					console.log(response.data);
				}
			};
			
			xhr.open("get", "./existByUserId?userid=" + inputIdValue);
			
			// 호출
			xhr.send();
			
		}
		
		function checkUserIdJquery(){
			const inputIdValue = $("#inputId").val();

			$.ajax({
				url: "./existByUserId?userid=" + inputIdValue,
				method: "get",
				dataType: "json",
				success: function(response){
					// CSR 수행
					console.log(response.result);
					console.log(response.data);
				}
			});
			
		}
		
		let isCheckedId = false;
		
		function checkUserIdFetch(){
			//ES6
			const inputIdValue = document.querySelector("#inputId").value;
			
			const url = "./existByUserId?userid=" + inputIdValue;
			
			fetch(url)
			.then(response => response.json())
			.then((response) => {
				
				// CSR - 클라이언트 사이트 렌더링... 여기가 힘듬
				if(response.data == true){
					//alert("이미 존재하는 아이디 입니다.");
					isCheckedId = false;
					
					const checkIdResultBox = document.getElementById("checkIdResultBox");
					checkIdResultBox.innerText = "이미 존재하는 아이디 입니다.";
					checkIdResultBox.style.color = "red";
					
					
				}else{
					//alert("사용 가능한 아이디 입니다.");
					isCheckedId = true;
					
					const checkIdResultBox = document.getElementById("checkIdResultBox");
					checkIdResultBox.innerText = "사용 가능한 아이디 입니다.";
					checkIdResultBox.style.color = "green";

				}
			})
			;
		}
		
	
	</script>
</head>
<body>
	<h1>회원 가입</h1>
	<form id="frm" action="./registerProcess" method="post">
		ID: <input onblur="checkUserIdFetch()" id="inputId" name="userid" type="text">
		<br>
		<div id="checkIdResultBox"></div>
		PW: <input id="inputPassword" name="password" type="password"><br>
		비밀번호 확인: <input id="inputPasswordConfirm" type="password"><br>
		
		
		닉네임: <input name="nickname" type="text"><br>
		이메일: <input name="email" type="text"><br>
		성별: 
		<input name="gender" type="radio" value="M">남
		<input name="gender" type="radio" value="F">여
		<br>
		취미:
		<c:forEach items="${hobbyList}" var="hobby">
			<input name="hobby_id" value="${hobby.id}" type="checkbox">${hobby.name }
		</c:forEach>

		
		<br>
		생일: <input name="birth" type="date"><br>
		전화번호: <input name="phone" type="text"><br> 
		
		<input type="button" onclick="formSubmit()" value="회원가입">
	</form>
	
	
	
</body>
</html>






