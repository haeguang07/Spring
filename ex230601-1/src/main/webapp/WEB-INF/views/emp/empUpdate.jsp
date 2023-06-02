<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<h1>사원수정</h1>
	<form action="empUpdate" method="POST" name="frm">
		<table>
			<tr>
				<td><input name="employeeId" value="${emp.employeeId }"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td>성(필수)<input name="lastName" value="${emp.lastName }">
				</td>
			</tr>
			<tr>
				<td>이름<input name="firstName" value="${emp.firstName }">
				</td>
			</tr>
			<tr>
				<td>이메일(필수)<input name="email" value="${emp.email}"></td>
			</tr>
			<tr>
				<td>전화<input name="phoneNumber" value="${emp.phoneNumber}"
					placeholder="XXX.XXX.XXXX">
			<tr>
				<td>직무(필수)<select name="jobId">
						<c:forEach items="${jobs}" var="job">
							<option value="${job.id}">${job.title}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>연봉<input name="salary" value="${emp.salary}">
				</td>
			</tr>
			<tr>
				<td>수당<input name="commissionPct" value="${emp.commissionPct}"></td>
			</tr>
			<tr>
				<td>사수<select name="managerId">
						<c:forEach items="${list }" var="em">
									<option value="${em.employeeId }" <c:if test="${em.employeeId==emp.managerId }"> selected</c:if>>${em.lastName }</option>
			
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>부서 <c:forEach items="${dept}" var="dpt">
						<label><input type="radio" value="${dpt.id }"
							name="departmentId"
							<c:if test="${dpt.id==emp.departmentId }">checked</c:if>>${dpt.name}</label>

					</c:forEach>

				</td>
			</tr>
		</table>
		<button>수정</button>
	</form>
	<script>
		frm.jobId.value="${emp.jobId}"
	</script>
</body>
</html>