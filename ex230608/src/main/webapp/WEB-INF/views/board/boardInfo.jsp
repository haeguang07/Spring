<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 정보</title>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<td>${board.bno}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="2" style="width: 100px;" readonly>
					${board.contents}
				</textarea></td>
		</tr>
		<tr>
			<th>파일</th>
			<td><c:choose>
					<c:when test="${board.image!=null}">
						<img src="${pageContext.request.contextPath}/img/${board.image}">
					</c:when>
					<c:otherwise>
						이미지 없음
					</c:otherwise>
				</c:choose></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${board.regdate}"
					pattern="yyyy-MM-dd" type="date" /></td>
		</tr>
	</table>
	<button type="button"
		onclick="location.href='boardUpdate?bno=${board.bno}'">수정</button>
	<button type="button"
		onclick="location.href='boardDelete?bno=${board.bno}'">삭제</button>
	<button type="button" onclick="location.href='boardList'">목록</button>
</body>
</html>