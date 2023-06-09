<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서별 대여매출 현황</title>
<style>
th {
	border: 1px solid black;
}

td {
	border: 1px solid black;
}

.centerT {
	text-align: center;
}

.rightT {
	text-align: right;
}
</style>
</head>
<body>
	<div class="centerT" style="margin: 20px auto;">
		<h3>도서별 대여매출 현황</h3>
	</div>
	<table class="table">
		<thead>
			<tr class="centerT">
				<th>도서번호</th>
				<th>도서명</th>
				<th>대여총계</th>
				<th>대여횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rentList}" var="rent">
				<tr>
					<td class="centerT">${rent.bookNo }</td>
					<td>${rent.bookName}</td>
					<td class="rightT">${rent.rentTotal }</td>
					<td class="rightT">${rent.rentCount }</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>