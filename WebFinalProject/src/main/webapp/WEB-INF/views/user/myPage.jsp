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

		<div class="col-2">
			<div class="row-1 border-end border-dark p-3">
				<span class="fs-5 fw-bolder  ">&nbsp;&nbsp;주문 배송</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;주문내역</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;취소/환불내역</span><br>
			</div>
			<div class="row-1 border-end border-dark p-3">
				<span class="fs-5 fw-bolder  ">&nbsp;&nbsp;알림 및 메시지</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;알림</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;메시지</span><br>
			</div>
			<div class="row-1 border-end border-dark p-3">
				<span class="fs-5 fw-bolder  ">&nbsp;&nbsp;선물함</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;받은 선물함</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;보낸 선물함	</span><br>
			</div>
			<div class="row-1 border-end border-dark p-3">
				<span class="fs-5 fw-bolder  ">&nbsp;&nbsp;나의 구매후기</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;후기 쓰기</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;내가 쓴 후기</span><br>
			</div>
			<div class="row-1 border-end border-dark p-3">
				<span class="fs-5 fw-bolder  ">&nbsp;&nbsp;관심리스트</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;찜 목록</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;팔로우하는 작가</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;최근 본 작품</span><br>
			</div>
			<div class="row-1 border-end border-dark p-3">
				<span class="fs-5 fw-bolder  ">&nbsp;&nbsp;할인혜택</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;VIP 클럽</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;idus share 적립금</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;쿠폰함</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;적립금</span><br>
				<span class="fs-6 ms-2">&nbsp;&nbsp;내 정보</span><br>
				<a href="./addAdressPage"><span class="fs-6 ms-2">&nbsp;&nbsp;배송지추가</span><br></a>
			</div>
		</div>
		<div class="row">
			<div class="col">
			
			</div>
		</div>
	</div>
</body>
</html>