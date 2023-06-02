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
				<td>성(필수)<input name="lastName">
				</td>
			</tr>
			<tr>
				<td>이름<input name="firstName">
				</td>
			</tr>
			<tr>
				<td>이메일(필수)<input name="email"></td>
			</tr>
			<tr>
				<td>전화<input name="phoneNumber" placeholder="XXX.XXX.XXXX">
					</label>
			<tr>
				<td>직무(필수)<select name="jobId">
						<c:forEach items="${jobs}" var="job">
							<option value="${job.id}">${job.title}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>연봉<input name="salary">
				</td>
			</tr>
			<tr>
				<td>수당<input name="commissionPct"></td>
			</tr>
			<tr>
				<td>사수<select name="managerId">
						<c:forEach items="${list }" var="emp">

							<option value="${emp.employeeId }">${emp.lastName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>부서
						<c:forEach items="${dept}" var="dpt">
							<label><input type="radio" value="${dpt.id }" name="departmentId">${dpt.name}</label>
						</c:forEach>
			
				</td>
			</tr>
		</table>
		<button>등록</button>
	</form>
</body>
</html>