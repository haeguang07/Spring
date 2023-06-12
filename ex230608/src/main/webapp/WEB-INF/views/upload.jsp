<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 업로드</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<div>
		<input type="file" name="uploadFiles" multiple >
		<button class="uploadBtn">Upload</button>	
	</div>
	<script>
		$('.uploadBtn').click(function(){
			var formData = new FormData();
			var inputFile = $("input[type='file']");
			//input태그의 type의 file인 것을 찾아서 inputFile 변수에 저장
			var files = inputFile[0].files;
			//files: 선택한 모든 파일을 나열하는 FilesList객체
			//multiple: 파일 여러건 업로드 가능

			for(var i=0; i<files.length; i++){
				console.log(files[i]);
				formData.append("uploadFiles", files[i]);
			}
			//실제 업로드 부분
			/*fetch('uploadsAjax',{
				method: 'post',
				body: formData
			})
			.then(response => response.text())
			.then(data=> console.log(data))
			.catch(err=> console.log(err));*/
			$.ajax({
				url:'uploadsAjax',
				type: 'post',
				processData: false,
				//기본값은 true, ajax통싱을 통해 데이터를 전송할 때, 기본적으로 Key 와Value값을 Query String으로 변환해서 보냄
				contentType: false,
				// multipart/form-data타일을 사용하기위해 false로 지정
				data: formData,
				success: function(result){
					console.log(result);
				},
				error: function(reject){
					console.log(reject);
				}
			})


		})


	</script>
	
	
	
</body>
</html>