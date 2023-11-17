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
		<div class="row ">
			<div class="col-1 "></div>
			<div class="col-5 mt-4 mr-3">
				<img src="../resources/ad_img/cake.jpg" class="img-thumbnail">
			</div>
			<dlv class="col-5 mt-5">
			<div class="row">
				<dlv class="col"> <i class="bi bi-person ml-3 mb-3 "></i> <span
					class="fs-6">${qwer.adminDto.shopname }> </span> <br>
				<span class="fs-4 p-3">${qwer.freeboardArticleDto.titlename }</span>
				<br>
				</dlv>
			</div>
			<div class="row">
				<div class="col-10">
					<span class="fs-3 fw-bolder ">${qwer.freeboardArticleDto.price }
						원</span><br>
				</div>
				<dlv class="col"> <i class="bi bi-heart ml-3 mb-3 "></i>
				&nbsp&nbsp&nbsp <i class="bi bi-share ml-3 mb-3 "></i> <br>
				</dlv>
			</div>
			<div class="row pt-3">
				<div class="col-8">
					<span class="fs-6">&nbsp;무료배송&nbsp;</span><br>
				</div>
				<dlv class="col"> <span class="fs-6">&nbsp;&nbsp;남은수량 :
					${qwer.freeboardArticleDto.total_count } 개</span> &nbsp </dlv>
			</div>
			<div class="row pt-3">
				<div class="col-8">
					<span class="fs-6">&nbsp;구매후기</span>
				</div>
			</div>
			<div class="row pt-3">
				<div class="col-3">
					<span class="fs-6">&nbsp;배송시작</span>
				</div>
				<div class="col">
					<span class="fs-6">평균 1일,최대 5일 이내</span><br>
				</div>
			</div>
			<div class="row pt-3">
				<div class="col-3">
					<span class="fs-6">&nbsp;결제혜택</span>
				</div>
				<div class="col">
					<span class="fs-6">토스페이&nbsp;&nbsp;&nbsp;</span><br> <span
						class="fs-6 text-secondary fst-italic"> 첫 결제시 0원 이상 2천원 캐시백</span><br>
					<span class="fs-6 ">네이버페이, KB Pay, KB Pay&nbsp;&nbsp;&nbsp;</span>
				</div>
			</div>
			<div class="row pt-3">
				<div class="col-3">
					<span class="fs-6">&nbsp;수량</span><br>

				</div>
				<div class="col">
					<span class="fs-6">주문시 제작</span><br>
				</div>
			</div>
			<div class="row pt-5">
				<div class="col d-grid p">
					<div class="btn-group" role="group" aria-label="Basic example">
						<button type="button" class="btn btn-outline-primary btn-lg">장바구니</button>
						<a href="./buyProduct?id=${qwer.freeboardArticleDto.id}" class="btn btn-primary btn-lg">구매하기</a>
						<button type="button" class="btn btn-primary btn-lg">선물하기</button>
					</div>
				</div>
			</div>
			<div class="row pt-3">
				<div class="col">
					<button type="button" class="btn btn-outline-primary">
					<i class="bi bi-megaphone ml-3 mb-3 "></i>&nbsp;작품문의</button>
					<span class="fs-6 text-sm-end">&nbsp;&nbsp;작품 관련 문의는 작품문의 버튼을 이용해주세요.</span>
				</div>
			</div>
			<br>
			<br>
			<br>

			</dlv>
		</div>
		<c:if
			test="${!empty sessionUserInfo && sessionUserInfo.id == map.freeboardArticleDto.user_id }">
			<a href="./deleteArticleProcess?id=${map.freeboardArticleDto.id }">삭제</a>
			<a href="./updateArticlePage?id=${map.freeboardArticleDto.id }">수정</a>
		</c:if>


		<br> <br> <br> <br> <br> 댓글 <br>
		<c:choose>
			<c:when test="${!empty sessionUserInfo}">
				<form action="./writeCommentProcess" method="post">
					<input name="article_id" type="hidden"
						value=${map.freeboardArticleDto.id }> <input
						name="user_id" type="hidden" value=${map.UserDto.id }> <input
						name="text" type="text"> <input type="submit"
						value="댓글 작성">
				</form>
			</c:when>
			<c:otherwise>
				<input type="text" value="로그인해주세요"
					onclick="location.href =  '../user/UserLoginPage';">
				<input type="submit" value="댓글 작성">
			</c:otherwise>
		</c:choose>

		<br>
		<table>
			<tr>
				<td>작성자</td>
				<td>내용</td>
				<td>등록일</td>
			</tr>

			<c:forEach items="${commentList }" var="map">
				<tr>
					<td>${map.userDto.nickname}</td>
					<td>${map.commentDto.text }</td>
					<td><fmt:formatDate value="${map.commentDto.created_at}"
							pattern="yy.MM.dd" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>



