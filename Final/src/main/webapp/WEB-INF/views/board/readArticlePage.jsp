<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<script>
	let myId = null;
	const articleId = ${qwer.freeboardArticleDto.id};
	
	function toggleLike(){
	
		fetch("./toggleLikeArticle?article_id=" + articleId)
		.then(response => response.json())
		.then(response => {
			reloadTotalCount();
			reloadHeart();
		});
	}
	
	function reloadTotalCount(){
		fetch("./getTotalLikeCount?article_id=" + articleId)
		.then(response => response.json())
		.then(response => {
			const totalCountBox = document.getElementById("totalCountBox");
			totalCountBox.innerText = response.data;
			
		});
	}
	
	function reloadHeart(){
		fetch("./isLike?article_id=" + articleId)
		.then(response => response.json())
		.then(response => {
			
			const heartBox = document.getElementById("heartBox");
			
			if(response.data == true){
				heartBox.classList.remove("bi-heart");
				heartBox.classList.add("bi-heart-fill");
			}else{
				heartBox.classList.remove("bi-heart-fill");
				heartBox.classList.add("bi-heart");				
			}
		});
	}
	
	function writeComment(){
		const inputComment = document.getElementById("inputComment");
		const commentValue = inputComment.value;
		
		const url = "./writeComment"
		
		fetch(url, {
			method: "post",
			headers: {
				"Content-Type": "application/x-www-form-urlencoded"
			},
			body: "text=" + commentValue + "&article_id=" + articleId
		})
		.then(response => response.json())
		.then(response => {
			inputComment.value = "";
			reloadCommentList();
		})
		;
		
	}
	
	function reloadCommentList(){
		
		const url = "./getCommentList?article_id=" + articleId;
		
		fetch(url)
		.then(response => response.json())
		.then(response => {
			
			//CSR - 클라이언트 사이드 렌더링
			const commentListBox = 
				document.getElementById("commentListBox");
			commentListBox.innerHTML = "";
			
			
			for(e of response.data){

				const commentWrapper = document.querySelector("#templete .commentWrapper").cloneNode(true);
				
				const commentNickname = commentWrapper.querySelector(".commentNickname");
				commentNickname.innerText = e.userDto.nickname;
				
				const commentDate = commentWrapper.querySelector(".commentDate");
				const date = new Date(e.commentDto.created_at);
				commentDate.innerText = date.getFullYear() + "." + (date.getMonth() + 1) + "." + date.getDate();
				
				const commentText = commentWrapper.querySelector(".commentText");	
				commentText.innerText = e.commentDto.text;
				
				const commentUpdate = commentWrapper.querySelector(".commentUpdate");
				const commentDelete = commentWrapper.querySelector(".commentDelete");

				commentUpdate.setAttribute("onclick", "showCommentUpdateForm(this, "+e.commentDto.id+")");
				commentDelete.setAttribute("onclick", "deleteComment("+e.commentDto.id+")");				
				
				if(myId == null || myId != e.commentDto.user_id){
					commentUpdate.remove();
					commentDelete.remove();
				}
				
				
				commentListBox.appendChild(commentWrapper);
			}
			
			
		});
	}
	
	
	function deleteComment(commentId){
		const url = "./deleteComment?comment_id=" + commentId;
		fetch(url)
		.then(response => response.json())
		.then(response => {
			reloadCommentList();
		});
	}
	
	function showCommentUpdateForm(targetElement, commentId){
		const updateCommentWrapper = document.querySelector("#templete .updateCommentWrapper").cloneNode(true);
		
		const commentWrapper = targetElement.closest(".commentWrapper");
		
		const commentText = commentWrapper.querySelector(".commentText");
		
		const text = commentText.innerText;
		commentText.innerHTML = "";
		
		updateCommentWrapper.querySelector(".inputComment").value = text;
		
		const updateCommentButton = updateCommentWrapper.querySelector(".updateCommentButton");
		updateCommentButton.setAttribute("onclick", "updateComment(this, "+commentId+")");
		
		commentText.appendChild(updateCommentWrapper);
	}
	
	function updateComment(targetElement, commentId){
		const updateCommentWrapper = targetElement.closest(".updateCommentWrapper");
		const inputComment = updateCommentWrapper.querySelector(".inputComment");
		
		const text = inputComment.value;
		
		const url = "./updateComment";
		const option = {
			method: "post",
			headers: {
				"Content-Type": "application/x-www-form-urlencoded"
			},
			body: "id=" + commentId + "&text=" + text
		};
		
		fetch(url, option)
		.then(response => response.json())
		.then(response => {
			reloadCommentList();
		});
		
	}
	
	
	
	window.addEventListener("DOMContentLoaded", () => {
		reloadTotalCount();
		reloadHeart();
		reloadCommentList();
		
		//setInterval(reloadCommentList, 15000);
	});
	
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
					<div class="commentNickname col-2 fw-bold">닉네임</div>
					<div class="commentDate col-3 text-secondary">2023.11.03</div>
				</div>
				<div class="row">
					<div class="commentText col-8">댓글 내용</div>
					<div class="commentUpdate col text-secondary">수정</div>
					<div class="commentDelete col text-secondary">삭제</div>
				</div>
			</div>
		</div>
	</div>
	

</body>
</html>



