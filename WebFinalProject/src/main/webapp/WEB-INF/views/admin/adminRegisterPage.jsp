<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
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
			<div class="col center">
				<form action="./adminRegisterProcess" method="post">
					<div class="row mt-5">
						<div class="col fw-bold fs-1 text-center">회원가입</div>
					</div>
					<div class="row mt-3">
						<div class="col d-grid">
							ID: <input name="userid" type="text" class="col center"><br>
							PW: <input name="password" type="password"><br> 
							쇼핑몰 이름:
							<input name="shopname" type="text"><br>
						</div>
					</div>
					<div class="row mt-3">
						<div class="row mt-3">
							<div class="col d-grid">
								<button type="submit" class="btn btn-primary">회원가입</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

</body>
</html>






