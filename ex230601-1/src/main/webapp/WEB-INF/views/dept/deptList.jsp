<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서조회</h1>
<a href="deptinsert">등록</a>
<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>매니저</th>
			<th>위치</th>

		</tr>
		<c:forEach var="item" items="${list}">

			<tr>
				<td>${item.departmentId }</td>
				<td>${item.departmentName }</td>
				<td>${item.managerId}</td>
				<td>${item.locationId }</td>
				<td><a href="deptUpdate?deptId=${item.departmentId}">수정</a></td>
				<td><a href="deptdelete?deptId=${item.departmentId}">삭제</a></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>