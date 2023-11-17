<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>SSS SHOP</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col">
				<jsp:include page="../commons/adtopNavi.jsp"></jsp:include>
			</div>
		</div>
	
		<div class="row mt-5">
			<div class="col"></div>
			<div class="col-6">
				<form action="./adminLoginProcess" method="get">
				<div class="row mt-5">
					<div class="col fw-bold fs-1 text-center">로그인(판매자)</div>
				</div>
				<div class="row mt-3">
					<div class="col">
						<input class="form-control" type="text" name="userid" placeholder="아이디">
					</div>
				</div>
				<div class="row mt-2">
					<div class="col">
						<input class="form-control" type="password" name="password" placeholder="비밀번호">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col d-grid">
						<button class="btn btn-primary">로그인</button>
					</div>
				</div>
				<div class="row mt-2">
					<div class="col d-grid">
						<a href="./adminRegisterPage" class="btn btn-outline-primary">회원가입</a>
					</div>
				</div>
				</form>
			</div>
			<div class="col"></div>
		</div>
	</div>
	



	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>