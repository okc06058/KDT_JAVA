<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<jsp:include page="../commons/topNavi.jsp"></jsp:include>
			</div>
		</div>
		<form action="./mainPage" method="get">
		<div class="row mt-3"><!-- 검색 -->
			<div class="col-2">
				<select name="searchType" class="form-select">
					<option value="title" ${searchType == 'title' ? 'selected' : null}>제목</option>
					<option value="content" ${searchType == 'content' ? 'selected' : null}>내용</option>
					<option value="nickname" ${searchType == 'nickname' ? 'selected' : null}>작성자</option>
				</select>				
			</div>
			<div class="col-8">
				<input name="searchWord" type="text" class="form-control" value="${searchWord}">
			</div>
			<div class="col-2 d-grid">
				<button class="btn btn-primary">검색</button>
			</div>
		</div>
		</form>


		<div class="row mt-2"><!-- 테이블 -->
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
				      <td><a href="./readArticlePage?id=${map.freeboardArticleDto.id}">${map.freeboardArticleDto.title}</a></td>
				      <td>${map.userDto.nickname}</td>
				      <td>${map.freeboardArticleDto.read_count}</td>
				      <td><fmt:formatDate value="${map.freeboardArticleDto.created_at}" pattern="yy.MM.dd"/></td>
				    </tr>
				  </c:forEach>
				  </tbody>
				</table>			
			</div>
		</div>
		
		<div class="row"><!-- 버튼 -->
			<div class="col-6">
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				  	<c:choose>
				  		<c:when test="${startPageNumber <= 1}">
							<li class="page-item disabled"><a class="page-link" href="./mainPage?pageNum=${startPageNumber-1}${searchQueryString}">&lt;</a></li>				  		
				  		</c:when>
				  		<c:otherwise>
							<li class="page-item"><a class="page-link" href="./mainPage?pageNum=${startPageNumber-1}${searchQueryString}">&lt;</a></li>				  		
				  		</c:otherwise>
				  	</c:choose>
				    <c:forEach begin="${startPageNumber}" end="${endPageNumber}" var="i">
				    	<c:choose>
				    		<c:when test="${currentPageNumber==i}">
				    			<li class="page-item active"><a class="page-link" href="./mainPage?pageNum=${i}${searchQueryString}">${i}</a></li>			
				    		</c:when>
				    		<c:otherwise>
				    			<li class="page-item"><a class="page-link" href="./mainPage?pageNum=${i}${searchQueryString}">${i}</a></li>
				    		</c:otherwise>
				    	</c:choose>
				    </c:forEach>
				    <c:choose>
				    	<c:when test="${endPageNumber >= totalPageNumber}">
							<li class="page-item disabled"><a class="page-link" href="./mainPage?pageNum=${endPageNumber+1}${searchQueryString}">&gt;</a></li>				    		
				    	</c:when>
				    	<c:otherwise>
							<li class="page-item"><a class="page-link" href="./mainPage?pageNum=${endPageNumber+1}${searchQueryString}">&gt;</a></li>				    	
				    	</c:otherwise>
				    </c:choose>
				  </ul>
				</nav>				
			</div>
			<div class="col-2 ms-auto d-grid">
				<c:if test="${!empty sessionUserInfo }">
					<a href="./writeArticlePage" class="btn btn-primary">글쓰기</a>
				</c:if>
			</div>
		</div>
	
	</div>

	<pre>
	
	</pre>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>