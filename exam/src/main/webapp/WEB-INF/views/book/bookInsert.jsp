<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>도서등록</title>
<style>
.centerT{
	text-align: center;
}
.rightT{
	text-align: right;
}
th{
	text-align: center;
	width: 100px;
}
input{
	width: 200px;
}
button{
	margin: 5px 10px;
}
</style>
</head>

<body>
	<div class="centerT" style="margin: 20px auto;">
		<h3>도서 등록</h3>
	</div>
	<div>
		<form onsubmit="return false;" name="insertForm">
			<table border="1" class="table">
				<tr>
					<th>도서번호</th>
					<td><input type="text" name="bookNo" value="${bookNo}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>도서명</th>
					<td><input type="text" name="bookName"></td>
				</tr>
				<tr>
					<th>도서표지</th>
					<td><input type="text" name="bookCoverimg" style="width: 400px;"></td>
				</tr>
				<tr>
					<th>출판일자</th>
					<td><input type="text" name="bookDate"></td>
				</tr>
				<tr>
					<th>금액</th>
					<td><input type="text" name="bookPrice"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input type="text" name="bookPublisher"></td>
				</tr>
				<tr>
					<th style="line-height: 101px;">도서소개</th>
					<td><textarea name="bookInfo" cols="50" rows="3"></textarea></td>
				</tr>
			</table>
			<div class="centerT">
				<button type="submit">등록</button>
				<button type="button" onclick="location.href='bookList'">조회</button>
			</div>
		</form>
	</div>

	<script>
	$('form[name=insertForm]').on('submit',function(e){
		e.preventDefault();
		let bookName=$(insertForm.bookName);
		if(bookName.val() ==''){
			alert('제목을 입력하세요');
			bookName.focus();
			return;
		}
		let boardData ={
			bookNo: $(insertForm.bookNo).val(),
			bookName: $(insertForm.bookName).val(),
			bookCoverimg: $(insertForm.bookCoverimg).val(),
			bookDate: $(insertForm.bookDate).val(),
			bookPrice: $(insertForm.bookPrice).val(),
			bookPublisher: $(insertForm.bookPublisher).val(),
			bookInfo: $(insertForm.bookInfo).val(),
		}
		$.ajax({
			url:'bookInsert',
			method:'post',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(boardData),
				success: function(data){
					console.log(data)
					if(data.result=='Success'){
						alert('도서등록이 성공했습니다');
						location.reload();
					}else{
						alert('실패');
					}
				},
				error: function(err){
					console.log(err);
				}

		})
	})
	
	

	</script>
</body>

</html>