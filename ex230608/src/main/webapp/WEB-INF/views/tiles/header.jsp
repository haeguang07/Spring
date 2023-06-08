<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/resources/css/headers.css" rel="stylesheet">

<div class="container">
	<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
		<a href="/" class="d-flex align-items-center mb-2 mb-lg-0 link-body-emphasis text-decoration-none">
			<svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
				<use xlink:href="#bootstrap" /></svg>
		</a>

		<ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
			<li><a href="#" class="nav-link px-2 link-secondary">home</a></li>
			<li><a href="boardList" class="nav-link px-2 link-body-emphasis">목록</a></li>
			<li><a href="boardInsert" class="nav-link px-2 link-body-emphasis">등록</a></li>
			<li><a href="#" class="nav-link px-2 link-body-emphasis">Products</a></li>
		</ul>

		<div class="dropdown text-end">
			<a href="#" class="d-block link-body-emphasis text-decoration-none dropdown-toggle" data-bs-toggle="dropdown"
				aria-expanded="false"> 
				<img src="https://previews.123rf.com/images/jemastock/jemastock1707/jemastock170706034/81722949-%ED%94%84%EB%A1%9C%ED%95%84-%EB%82%A8%EC%9E%90-%EC%BA%90%EB%A6%AD%ED%84%B0-%EB%B9%84%EC%A6%88%EB%8B%88%EC%8A%A4-%EC%A7%81%EC%9B%90-%EB%A7%8C%ED%99%94-%EB%B2%A1%ED%84%B0-%EC%9D%BC%EB%9F%AC%EC%8A%A4%ED%8A%B8-%EB%A0%88%EC%9D%B4%EC%85%98.jpg"
					alt="mdo" width="32" height="32" class="rounded-circle">
			</a>
			<ul class="dropdown-menu text-small">
				<li><a class="dropdown-item" href="#">New project...</a></li>
				<li><a class="dropdown-item" href="#">Settings</a></li>
				<li><a class="dropdown-item" href="#">Profile</a></li>
				<li>
					<hr class="dropdown-divider">
				</li>
				<li><a class="dropdown-item" href="#">Sign out</a></li>
			</ul>
		</div>
	</div>
</div>
