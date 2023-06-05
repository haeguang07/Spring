<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서조회</title>
</head>
<body>
	<h1>부서조회</h1>
	<a href="deptinsert">등록</a>
	<table border="1">
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>매니저 번호</th>
				<th>지역번호</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dept" items="${deptList}">
				<tr>
					<td><input type="checkbox"></td>
					<td>${dept.departmentId }</td>
					<td>${dept.departmentName }</td>
					<td>${dept.managerId}</td>
					<td>${dept.locationId }</td>
					<td><button type="button" >삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>