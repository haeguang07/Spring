<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P> <span id="time"></span> </P>

<script>

function getTime() {//반복할 함수
	let d = new Date();	// 현재 날짜와 시간

	let hur = d.getHours();		// 시
	let min = d.getMinutes();	//분
	let sec = d.getSeconds();	//초
	let timeBoard = document.getElementById("time"); // 값이 입력될 공간	
	let time = "현재 시간 : " + hur + "시 " + min + "분 " + sec + "초"	// 형식 지정
	let ti=0;

	timeBoard.innerHTML = time;	// 출력
}	
	let evt=setInterval(getTime, 1000);	//1000밀리초(1초) 마다 반복
	
</script>
</body>
</html>
