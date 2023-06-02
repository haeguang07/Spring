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
	<h1>사원등록</h1>
	<form action="empInsert" method="POST">
		<table>

			<tr>
				<td>이름<input name="departmentName">
				</td>
			</tr>
			<tr>
				<td>매지저
				<select name="managerId">
						<c:forEach items="${empList}" var="emp">
							<option value="${emp.employeeid}">${emp.lastName}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			
			<tr>
				<td>위치<select name="locationId">
						<c:forEach items="${loList }" var="lo">
							<option value="${lo.id }">${lo.city }</option>
						</c:forEach>
				</select>
				</td>
			</tr>
		</table>
		<button>등록</button>
	</form>
</body>
</html>