<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<style>
table {
	border-collapse: collapse;
}
</style>
</head>
<body>
	<h1>사원 조회</h1>
	<a href="empInsert">등록</a>
	<form action="empList">
		<label>부서번호<input type="text" name="departmentId" value="${emp.departmentId }"></label>
		<label>이름<input type="text" name="firstName" value="${emp.firstName }"></label>
		<button>검색</button>
		<button type="button" id="reset">초기화</button>
	</form>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>성</th>
			<th>이름</th>
			<th>부서번호</th>
			<th>이메일</th>
			<th>직업</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="item" items="${empList}">

			<tr>
				<td>${item.employeeId }</td>
				<td>${item.lastName }</td>
				<td>${item.firstName=  item.firstName==null? 'none' : item.firstName }</td>
				<td>${item.departmentId =  item.departmentId==null? 'none' : item.departmentId }</td>
				<td>${item.email}</td>
				<td>${item.jobId }</td>
				<td><a href="empUpdate?empNo=${item.employeeId}">수정</a></td>
				<td><a href="empDelete?empNo=${item.employeeId}">삭제</a></td>
			</tr>

		</c:forEach>
	</table>
<script>
$(
	$('#reset').on('click',function(){
		$('input').each((index,item)=>$(item).val('') )
	})
	
	
)


</script>


</body>
</html>