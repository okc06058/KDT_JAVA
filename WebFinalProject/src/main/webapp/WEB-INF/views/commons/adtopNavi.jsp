<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
	
<div class="row">
	<!-- 네비 -->
	<div class="col">
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">SSS SHOP</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a href="../admin/adminMainPage"
							class="nav-link active" aria-current="page" href="#">쇼핑몰(판매자)</a></li>
						<li class="nav-item"><a href="../admin/adminMainPage" class="nav-link" href="#">Shop</a></li>
						</li>

						<c:choose>
							<c:when test="${!empty sessionAdminInfo }">
								<li class="nav-item dropdown ms-auto"><a
									class="fw-bold nav-link dropdown-toggle" href="#" role="button"
									data-bs-toggle="dropdown" aria-expanded="false">
										${sessionAdminInfo.shopname } </a>
									<ul class="dropdown-menu">
										<li><a class="dropdown-item" href="#">마이페이지</a></li>
										<li><a class="dropdown-item" href="#">Another action</a></li>
										<li><hr class="dropdown-divider"></li>
										<li><a href="../admin/adminLogoutProcess"
											class="dropdown-item" href="#">로그아웃</a></li>
									</ul></li>
							</c:when>
							<c:otherwise>
								<li class="nav-item"><a href="../admin/adminLoginPage"
									class="nav-link">로그인</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</div>
