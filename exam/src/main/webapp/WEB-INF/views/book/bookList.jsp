<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 조회/수정</title>
<style>
.centerT{
	text-align: center;
}
.rightT{
	text-align: right;
}
th {
	border: 1px solid black;
	text-align: center;
}

td {
	border: 1px solid black;
	padding: 0;
}
</style>
</head>
<body>
	<div class="centerT" style="margin: 20px auto;">
		<h3>도서 조회/수정</h3>
	</div>
	<table border="1" class="table">
		<thead>
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>표지</th>
				<th>출판일자</th>
				<th>금액</th>
				<th>출판사</th>
				<th>도서소개</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td class="centerT">${book.bookNo }</td>
					<td>${book.bookName}</td>
					<td class="centerT">
						<img src="${pageContext.request.contextPath}/resources/images/${book.bookCoverimg }" style="width: 30px;">
					</td>
					<td class="centerT">
						<fmt:parseDate var="dateString" value="${book.bookDate}" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${dateString }" pattern="yyyy/MM/dd"/> 
					</td>
					<td class="rightT">
						<fmt:formatNumber value="${book.bookPrice}"/>
					</td>
					<td>${book.bookPublisher}</td>
					<td>${book.bookInfo}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>