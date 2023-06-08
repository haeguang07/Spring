<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>

<form action="boardUpdate" method="post">
	<table>
		<tr>
			<th>번호</th>
			<td><input type="text" readonly value="${board.bno}" name="bno"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" value="${board.title}" name="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" value="${board.writer}" name="writer"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="2" style="width: 100px;" name="contents">
					${board.contents}
				</textarea>
			</td>
		</tr>
		<tr>
			<th>첨부이미지</th>
			<td><input type="file" name="image"></td>
		</tr>
		<tr>
			<th>수정일</th>
			<td><input type="date" name="updatedate" value="<fmt:formatDate value="${board.updatedate}" pattern="yyyy-MM-dd" type="date"/>"></td>
		</tr>
	</table>
	<button type="submit">수정완료</button>
	<button type="button" onclick="location.href='boardInfo?bno=${board.bno }'">취소</button>
</form>
</body>
</html>