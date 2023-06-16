function init() {
  //페이지를 열었을 때 처음 설정하는 부분

  //서버와 통신
  //1) 전체 사원 조회
  getEmpList();
  //2) 업무 select안에 option 넣기
  getAllJob();


  //이벤트
  //등록버튼
  document.querySelector('form').addEventListener('submit', insertEmpInfo);

  //수정버튼
  document.querySelectorAll('form button')[2].addEventListener('click', updateEmpInfo);

  //선택 삭제 버튼
  document.querySelector('#checkDelBtn').addEventListener('click', deleteEmpInfo)
  //select 버튼 값을 input의 넣기
  document.querySelector('#job').addEventListener('change', printSelectJob)
  //id 속성이 allChk인 input(checkbox) 
  document.querySelector('#allChk').addEventListener('click', isAllChecked)


}
const feild = ['employee_id', 'first_name', 'job_id']

function getEmpList() {
  fetch('http://192.168.0.51:8081/myserver/empSelect')
    .then(response => response.json())
    .then(data => {
      let tbody = document.getElementById('empList');
      for (let emp of data) {
        let obj = {}
        for (let f of feild) {
          obj[f] = emp[f];
        }
        let tr = makeTr(obj);
        tbody.append(tr);

      }
    })
    .catch(err => console.log(err));
}

function getAllJob() {
  fetch('http://192.168.0.51:8081/myserver/empJob')
    .then(response => response.json())
    .then(data => {
      let selTag = document.getElementById('job');
      data.jobs.forEach(job => {
        let option = document.createElement('option');
        option.value = job.job_id
        option.textContent = job.job_title;
        selTag.append(option);
      })
    })
    .catch(err => console.log(err))
}







function makeTr(obj) {
  let tr = document.createElement('tr');
  let td = document.createElement('td');
  let check = document.createElement('input');
  check.setAttribute('type', 'checkbox');
  check.className = 'check';
  check.value = obj['employee_id']
  td.append(check)
  tr.append(td);

  for (let f in obj) {
    td = document.createElement('td');
    td.textContent = obj[f];
    tr.append(td);
  }
  td = document.createElement('td');
  let button = document.createElement('button');
  button.textContent = "삭제";
  button.addEventListener('click', function () {
    empDelete(this);

  });
  td.append(button);

  tr.append(td);
  tr.addEventListener('click', function (e) {
    if (e.target.tagName == 'BUTTON') return;
    updateInfo(this);
  })
  return tr;
}






//테이블 안에 이벤트
//1) 개별 삭제
function empDelete(button) {
  let row = button.closest('tr');
  let data = {
    "employee_id": row.children[1].textContent
  };
  fetch('http://192.168.0.51:8081/myserver/empDelete', {
      method: 'post',
      headers: {
        'content-type': 'application/json'
      },
      body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(result => {
      if (result['employee_id'] > 0) {
        row.remove();
      }
    })
    .catch(err => console.log(err))
}






//tr 클릭시 단건조회 해서
function updateInfo(tr) {
  let employeeId = tr.children[1].textContent;
  fetch('http://192.168.0.51:8081/myserver/empFind?employee_id=' + employeeId)
    .then(response => response.json())
    .then(data => {
      formData(data);
    })
    .catch(err => console.log(err))

}
//단건 조회 후 form에 출력;
function formData(emp) {
  let inputList = document.querySelectorAll('form input');
  inputList.forEach(input => {
    let name = input.getAttribute('name');
    if (name != 'hire_date') {
      input.value = emp[name];
    } else {
      let hireDate = new Date(emp[name])
      let year = hireDate.getFullYear();
      let month = (hireDate.getMonth() + 1) < 10 ? '0' + (hireDate.getMonth() + 1) : (hireDate.getMonth() + 1);
      let date = hireDate.getDate() < 10 ? '0' + hireDate.getDate() : hireDate.getDate();
      input.value = year + '-' + month + '-' + date;
    }
    if (name == 'job_id') {
      document.querySelector('#job').value = emp[name];
    }
  });

}


// 등록
function insertEmpInfo(e) {
  event.preventDefault();
  let inputList = document.querySelectorAll('form input');
  let obj = {};
  inputList.forEach(input=>{
    obj[input.getAttribute('name')]= input.value;
    if(input.value ==''){
      alert(input.getAttribute('name')+'이 입력 되지 않았습니다');
      return;
    }
  })
  fetch('http://192.168.0.51:8081/myserver/empInsert',{
    method: 'post',
    headers:{
      'content-type': 'application/json'
    },
    body: JSON.stringify(obj)
  })
  .then(response => response.json())
  .then(data=> {
    if(data.employee_id>0){
      alert('등록 성공');
      location.reload();
    }
  })
}

// 수정
function updateEmpInfo(e) {
  let inputList = document.querySelectorAll('form input');
  let obj = {};
  inputList.forEach(input=>{
    obj[input.getAttribute('name')]= input.value;
    if(input.value ==''){
      alert(input.getAttribute('name')+'이 입력 되지 않았습니다');
      return;
    }
  })
  fetch('http://192.168.0.51:8081/myserver/empUpdate',{
    method:'post',
    headers: {
      'content-type': 'application/json'
    },
    body: JSON.stringify(obj)
  })
  .then(response=> response.json())
  .then(data=> {
    if(data.employee_id>0){
      alert('성공');
      location.reload();
    }
  })
}
//선택된 사원 삭제
function deleteEmpInfo(e) {
  let checkInputList= document.querySelectorAll('td>input[type="checkbox"]:checked');
  let delList=[];
  if(checkInputList.length>0){
    checkInputList.forEach(item=>{
      if(item.id != 'allChk'){
        let obj = {};
        obj.employee_id=item.value;
        delList.push(obj)
      }
    })
  }
  console.log(delList);
  fetch('http://192.168.0.51:8081/myserver/empListDelete',{
    method:'post',
    headers: {
      'content-type': 'application/json'
    },
    body: JSON.stringify(delList)
  })
  .then(response => response.json())
  .then(data=>{
    if(data.success>0){
      alert('삭제건수:'+ data.total +
            '\n성공건수'+ data.success);
      location.reload();
    }
  })
  .catch(err=> console.log(err))
}
//selected => input 출력
function printSelectJob(e) {
  let selectTag = event.currentTarget;
  let selectedVal = selectTag.options[selectTag.selectedIndex].value;
  selectTag.nextElementSibling.value = selectedVal;
}
//전체 선택
function isAllChecked(e) {
  let checkInputList= document.querySelectorAll('td>input[type="checkbox"]');
  if (event.currentTarget.checked){
    checkInputList.forEach(item=>{
      item.checked=true;
    })
  }else{
    checkInputList.forEach(item=>{
      item.checked=false;
    })
  }
}
//개별 모두 되면 선