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
	<form action="deptInsert" method="POST">

		<div>
			<label for="name">부서이름</label>
			 <input type="text" id="name" name="departmentName" required="required">
		</div>
		<div>
			매니저<select name="managerId">
				<c:forEach items="${empList }" var="emp">
					<option value="${emp.employeeId }">${emp.lastName }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			위치<select name="locationId">
				<c:forEach items="${locations }" var="lo">
					<option value="${lo.id }">${lo.city }</option>
				</c:forEach>
			</select>
			
		</div>
		<div>
			<button type="submit">등록</button>
			<button type="button" onclick="location.href='deptList'">목록</button>
		</div>

	</form>
</body>
</html>