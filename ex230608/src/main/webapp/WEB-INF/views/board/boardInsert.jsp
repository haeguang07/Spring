<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>게시글 등록</title>
</head>

<body>
	<form action="boardInsert" name="boardForm" method="post" onsubmit="return false">
		<div>
			<h3>게시글 정보</h3>
		</div>
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents" cols="30" rows="10"></textarea>
				</td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td><input type="text" name="image"></td>
			</tr>

		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='boardList'">목록</button>
	</form>
</body>
	<script>
		/*$('button[type="submit"]').on('click',function insertBoard(e){
			let title=boardForm.title.value;
			let writer=boardForm.writer.value;
			let contents=boardForm.contents.value;
			if(title==''){
				alert('제목을 입력하세요');
				return;
			}
			if(writer==''){
				alert('작성자를 입력하세요');
				return;
			}
			if(contents==''){
				alert('내용을 입력하세요');
				return;
			}
			let boardData = {
					title:title,
					writer:writer,
					contents:contents,
					image: (boardForm.image.value).substring(12)
			}
			$.ajax({
				url:'boards',
				method: 'post',
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(boardData),
				success: function(data){
					console.log(data)
					if(data.result=='Success'){
						alert('성공');
						location.href='boardList';	
					}else{
						alert('실패');
					}
				},
				error: function(err){
					console.log(err);
				}
			})
		})*/
		document.querySelector('form[name=boardForm]').addEventListener('submit',function(e){
			e.preventDefault();
			let title=boardForm.title;
			let writer=boardForm.writer;
			let contents=boardForm.contents;
			if(title.value==''){
				alert('제목을 입력하세요');
				title.focus();
				return;
			}
			if(writer.value==''){
				alert('작성자를 입력하세요');
				writer.focus();
				return;
			}
			if(contents.value==''){
				alert('내용을 입력하세요');
				writer.focus();
				return;
			}
			boardForm.submit();
		})

		

	</script>
</html>