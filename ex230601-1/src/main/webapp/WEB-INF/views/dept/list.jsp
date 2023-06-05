<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>부서조회</title>
</head>

<body>
	<h1>부서조회</h1>
	<a href="deptInsert">등록</a>
	<button type="button" id="checkDel">선택삭제</button>
	<table>
		<thead>
			<tr>
				<th><input type="checkbox" value="all"></th>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>매니저 번호</th>
				<th>지역번호</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dept" items="${deptList}">
				<tr> <!-- onclick="findDeptInfo(event,${dept.departmentId})" --> 
					<td><input type="checkbox" name="departmentId"
						value="${dept.departmentId}"></td>
					<td>${dept.departmentId }</td>
					<td><a href='deptInfo?departmentId=${dept.departmentId}'>${dept.departmentName}</a></td>
					<td>${dept.managerId}</td>
					<td>${dept.locationId }</td>
					<td><button type="button" class="delBtn">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form name="del" action="deptDelete" method="get"></form>
	<script>
		let result = "${departmentId}";
		if (result != "") {
			console.log(result);
		}
		

		document.getElementById('checkDel').addEventListener('click', function (e) {
			let checked = document.querySelectorAll('input[type=checkbox]:checked')
			if(checked.length>0){
				for (let i = 0; i < checked.length; i++) {
					let deptNo = checked[i].parentElement.nextElementSibling.textContent;
					insertDeptInfo(i, deptNo)
				}
				del.submit();
			}
		})
		
		document.querySelectorAll('.delBtn').forEach(item=>{
			item.addEventListener('click',function(){
				let deptNo = this.parentElement.parentElement.children[1].textContent
				insertDeptInfo(0, deptNo);
				del.submit();
			})
		})

		function insertDeptInfo(index, deptNo) {
			let inputTag = document.createElement('input');
			inputTag.type = "hidden";
			inputTag.name = 'deptList[' + index + '].departmentId';
			inputTag.value = deptNo;
			let formTag = document.getElementsByName('del')[0];
			formTag.append(inputTag)
		}
		
		function findDeptInfo(event , deptId){
			/*
				event.target//실제 이벤트가 발생한 태그: 고정값
				event.currentTarget//this 같은 의미 => 지금 해당 이벤트에 대하 동작을 하는 태그 
				event.preventDefault()//기본으로 등록된 이벤트의 동작을 막음
				event.stopPropagation()//이벤트 버블링(전파) 막음
			*/
			if(event.target.tagName!='INPUT' && event.target.tagName!='BUTTON' ){
				location.href='deptInfo?departmentId='+deptId;
			}

		}
	</script>
</body>

</html>