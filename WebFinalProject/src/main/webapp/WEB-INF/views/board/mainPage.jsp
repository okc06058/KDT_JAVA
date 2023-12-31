<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
				<jsp:include page="../commons/topNavi.jsp"></jsp:include>
			</div>
		</div>
		<div class="row mt-3">
			<!-- 검색 -->
			<div class="col-2">
				<select class="form-select">
					<option selected>식품</option>
					<option>뷰티</option>
					<option>공예</option>
				</select>
			</div>
			<div class="col-8">
				<input type="text" class="form-control">
			</div>
			<div class="col-2 d-grid">
				<button class="btn btn-primary">검색</button>
			</div>
		</div>

		<div id="carouselExample" class="carousel slide mt-3">
			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="carousel-item active">
					<div style="height: 200px; background: #896AB7; alt="..."></div>
				</div>
				<div class="carousel-item ">
					<div style="height: 200px; background: #C4B68F; alt="..."></div>

				</div>
			</div>

			<!-- Controls -->
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExample" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExample" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>

		</div>

		<div class="row mt-2">
			<!-- 테이블 -->
			<div class="col">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th scope="col">글번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">조회수</th>
							<th scope="col">작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="map">
							<tr>
								<th scope="row">${map.freeboardArticleDto.id}</th>
								<td><a
									href="./readArticlePage?id=${map.freeboardArticleDto.id}">${map.freeboardArticleDto.title}</a></td>
								<td>${map.userDto.nickname}</td>
								<td>${map.freeboardArticleDto.read_count}</td>
								<td><fmt:formatDate
										value="${map.freeboardArticleDto.created_at}"
										pattern="yy.MM.dd" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

</body>
</html>