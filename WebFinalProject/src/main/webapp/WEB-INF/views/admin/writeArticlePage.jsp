
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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

		<div class="row mt-1">
			<div class="col center">
				<form action="./writeArticleProcess" method="post" enctype="multipart/form-data">
					<div class="row mt-5">
						<div class="col fw-bold fs-1 text-center">상품 등록하기</div>
					</div>
					<div class="row mt-3">
						<div class="col d-grid">
							물품명: <input name="titlename" type="text"><br> 상세 설명:
							<textarea name="content" rows="10" cols="60"></textarea>
							가격: <input name="price" type="number"><br> 
							사진 등록: <input name="imageFiles" type="file" accept="image/*" multiple>
							<br> 카테고리 선택:
							<div class="col mt-2 mb-1">
							<c:forEach items="${categoryList}" var="category">
								<input name="category" value="${category.id}" type="checkbox">&nbsp${category.name}&nbsp&nbsp
							</c:forEach><br> 
							</div>
							총 판매 수량: <input name="total_count" type="number"><br>
							<button type="submit" class="btn btn-primary">글 작성</button>
							<br> <br>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>







