<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판목록</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody id="list">
			<c:forEach items="${boardList }" var="board">

				<tr>
					<td>${board.bno }</td>
					<td><a href="boardInfo?bno=${board.bno }">${board.title }</a></td>
					<td>${board.writer }</td>
					<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" type="date"/></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<script>
		/*$.ajax({
			url:"",
			method:'get',
			success:function(data){
				data.forEach(element => {
					
				});
				$('#list')
			},
			error: function(err){
				console.log(err)
			}
		})*/
	
	</script>
</body>
</html>