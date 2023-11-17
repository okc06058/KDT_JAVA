<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<title>SSS SHOP</title>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<jsp:include page="../commons/topNavi.jsp"></jsp:include>
			</div>
		</div>
		<div class="row ">
			<div class="col">
				<ul class="nav justify-content-around bg-primary-subtle">
					<li class="nav-item "><a class="nav-link active"
						aria-current="page" href="#">실시간 구매</a></li>
					<li class="nav-item"><a class="nav-link" href="#">실시간 후기</a></li>
					<li class="nav-item"><a class="nav-link" href="#">작가님 추천</a></li>
					<li class="nav-item"><a class="nav-link" href="#">인기 작품</a></li>
					<li class="nav-item"><a class="nav-link" href="#">작가 피드</a></li>
					<li class="nav-item"><a class="nav-link" href="#">최신 작품</a></li>
					<li class="nav-item"><a class="nav-link disabled"
						aria-disabled="true">매거진</a></li>
				</ul>
			</div>
		</div>
		<div class="row p-4 ">
			<div class="col ">
				<span class="fs-2 fw-bolder">주문 결제</span>
			</div>
		</div>
		<div class="row p-3 border-bottom border-dark ms-2">
			<div class="col">
				<span class="fs-5 fw-bolder ">&nbsp;&nbsp;주문 고객</span>
			</div>
		</div>
		<div class="row mt-3 ms-3">
			<div class="col-2 ms-4 ">
				<span class="fs-6">이름</span><br> <span class="fs-6 pt-5">전화번호</span>
			</div>
			<div class="col">
				<span class="fs-6">${sessionUserInfo.nickname}</span> <br> <span
					class="fs-6 pt-5">010-0000-0000</span>
			</div>
		</div>
		<br> <br>
		<div class="row p-3 border-bottom border-dark ms-2">
			<div class="col">
				<span class="fs-5 fw-bolder ">&nbsp;&nbsp;배송 정보</span>
			</div>
		</div>
		<div class="row mt-3 ms-3">
			<div class="col-2 ms-4 mb-2">
				<span class="badge bg-primary">기본배송지</span><br> <span
					class="fs-6 pt-5">전화번호</span><br> <span class="fs-6 pt-5">주소</span><br>
			</div>
			<div class="col">	
				<span class="fs-6">${sss.adress_name }</span> <br>
				<span class="fs-6 pt-5">010-0000-0000</span><br>
				<c:forEach items="${AdressList}" var="map">
					<div class="form-check">
						<input class="form-check-input" type="radio"
							name="flexRadioDefault" id="flexRadioDefault1" > <label
							class="form-check-label" for="flexRadioDefault1">
							${map.adress }</label>

					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>