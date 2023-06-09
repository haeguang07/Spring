<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>게시글 수정</title>
</head>

<body>
	<form onsubmit="return false">
		<table>
			<tr>
				<th>번호</th>
				<td><input type="text" readonly value="${board.bno}" name="bno" id="bno"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" value="${board.title}" name="title" id="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" value="${board.writer}" name="writer" id="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="20" rows="4" name="contents" id="contents">${board.contents}</textarea></td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td><input type="file" name="image" id="image"></td>
			</tr>
			<tr>
				<th>수정일</th>
				<td><input type="date" name="updatedate" id="updatedate" value="<fmt:formatDate value="${board.updatedate}"
						pattern="yyyy-MM-dd" type="date" />"></td>
			</tr>
		</table>
		<button type="submit">수정완료</button>
		<button type="button" onclick="location.href='boardInfo?bno=${board.bno}'">취소</button>
	</form>
	<script>
		$('button[type=submit]').on('click', function () {
			Fdata = {
				bno: $('#bno').val(),
				title: $('#title').val(),
				writer: $('#writer').val(),
				contents: $('#contents').val(),
				image: $('#image').val(),
				updatedate: $('#updatedate').val()
			}
			console.log(Fdata)
			$.ajax({
				url: 'boards',
				method: 'PUT',
				data: JSON.stringify(Fdata),
				contentType: 'application/json; charset=utf-8',
				success: function (data) {
					if (data.result == 'Success') {
						alert('성공');
						location.href='boardList';
					} else {
						alert('실패');
					}
				},
				error: function (error) {
					console.log(error);
				}
			})
		})
	</script>

</body>

</html>