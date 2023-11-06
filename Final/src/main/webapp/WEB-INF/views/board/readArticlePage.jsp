<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>


</script>
</head>
<body>
	<h1>게시글</h1>
	
	제목: ${qwer.freeboardArticleDto.title }<br>
	작성자: ${qwer.userDto.nickname }<br>
	조회수: ${qwer.freeboardArticleDto.read_count }<br>
	내용: <br>
	${qwer.freeboardArticleDto.content }<br>
	
	<br><br>
	
	<c:forEach items="${qwer.articleImageDtoList}" var="articleImageDto">
		<img src="/uploadFiles/${articleImageDto.location}"><br>
	</c:forEach>
	
	<br><br>
	
	<a href="./mainPage">목록으로</a>
	
	<div class="container">
	<!-- 댓글 입력 창 -->
		<div class="row">
			<div class="col-8">
				<textarea id="inputComment" class="form-control"></textarea>
			</div>
			<div class="col d-grid">
				<button onclick="writeComment()" class="btn btn-primary">입력</button>
			</div>
		</div>
		<!-- 댓글 리스트 -->
		<div class="row">
			<div class="col fw-bold fs-5 mt-3 mb-2">댓글 리스트</div>
		</div>
		<div class="row">
			<div id="commentListBox" class="col"></div>
		</div>
		
		
	</div>
	<div id="templete" class="d-none">
		<div class="commentWrapper row border-top">
			<div class="col">
				<div class="row">
					<div class="commentNickname col-2 fw-bold">닉네임 나오는 곳</div>
					<div class="commentDate col-3 text-secondary">2023.11.03</div>
				</div>
				<div class="row">
					<div class="commentText col-8">댓글 내용 블라블라....</div>
					<div class="commentUpdate col text-secondary">수정</div>
					<div class="commentDelete col text-secondary">삭제</div>
				</div>
			</div>
		</div>	
	
	
		<div class="row updateCommentWrapper">
			<div class="col-6">
				<input type="text" class="inputComment form-control">
			</div>
			<div class="col updateCommentButton">저장</div>
			<div onclick="reloadCommentList()" class="col">취소</div>
		</div>
	
	</div>
	
	
	
	<c:if test="${!empty sessionUserInfo && sessionUserInfo.id == qwer.freeboardArticleDto.user_id }">
		<a href="./deleteArticleProcess?id=${qwer.freeboardArticleDto.id }">삭제</a>
		<a href="./updateArticlePage?id=${qwer.freeboardArticleDto.id }">수정</a>	
	</c:if>
	
</body>
</html>



