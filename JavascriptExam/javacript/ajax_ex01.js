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
      tbody.replaceChildren();
      for (let emp of data) {
        let max = 0;
        let obj = {}
        for (let f of feild) {
          obj[f] = emp[f];
        }
        let tr = makeTr(obj);
        tbody.append(tr);
        if (max < emp['employee_id']) {
          max = (emp['employee_id'] * 1) + 1;
        }
        document.querySelector('input[name="employee_id"]').value = max


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
    if (e.target.tagName == 'BUTTON'
        || e.target.type == 'checkbox') return;
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
      let empId = result['employee_id'];
      let empTag = document.querySelectorAll('tbody tr>td:nth-child(2)')
      empTag.forEach(tag => {
        if (tag.textContent == data['employee_id']) {
          tag.parentElement.remove();
        }
      })
    })
    .catch(err => console.log(err))
}






//tr 클릭시 단건조회 해서
function updateInfo(tr) {
  let employeeId = tr.children[1].textContent;
  fetch('http://192.168.0.51:8081/myserver/empFind?employee_id=' + employeeId)
    .then(response => response.json())
    .then(data => {
      console.log(data);
      printData(data);
    })
    .catch(err => console.log(err))

}

//단건 조회 후 form에 출력;
function printData(emp) {
  let inputList = document.querySelectorAll('form input');

  inputList.forEach(input => {
    let name = input.name;
    let objVal = emp[name]
    if (name == 'hire_date') {
      objVal = getHireDate(emp[name]);
    }
    input.value = objVal;
    if (name == 'job_id') {
      document.querySelector('#job').value = objVal;
      //input.previousElementSibling.value=objVal;
    }
  });

}

function getHireDate(data) {
  let hireDate = new Date(data)
  let year = hireDate.getFullYear();
  //let month = (hireDate.getMonth() + 1) < 10 ? '0' + (hireDate.getMonth() + 1) : (hireDate.getMonth() + 1);
  let month = ('0' + (hireDate.getMonth() + 1)).slice(-2)
  //let date = hireDate.getDate() < 10 ? '0' + hireDate.getDate() : hireDate.getDate();
  let date = ('0' + hireDate.getDate()).slice(-2)
  return `${year}-${month}-${date}`;
}


//form input를 객체 만들기
function getFormInfo() {
  let empInfo = {};
  let inputList = document.querySelectorAll('form input');
  inputList.forEach(input => {
    empInfo[input.name] = input.value;
  })

  return empInfo;
}


// 등록
function insertEmpInfo(e) {
  event.preventDefault();
  let empInfo = getFormInfo();



  fetch('http://192.168.0.51:8081/myserver/empInsert', {
      method: 'post',
      headers: {
        'content-type': 'application/json'
      },
      body: JSON.stringify(empInfo)
    })
    .then(response => response.json())
    .then(data => {
      if (data.employee_id > 0) {
        alert('등록 성공');
        getEmpList();
      }
    })

}

// 수정
function updateEmpInfo(e) {
  let empInfo = getFormInfo();

  fetch('http://192.168.0.51:8081/myserver/empUpdate', {
      method: 'post',
      headers: {
        'content-type': 'application/json'
      },
      body: JSON.stringify(empInfo)
    })
    .then(response => response.json())
    .then(data => {
      if (data.employee_id > 0) {
        alert('성공');
        location.reload();
      }
    })
}


//선택된 사원 삭제
function deleteEmpInfo(e) {
  let checkInputList = document.querySelectorAll('input[type="checkbox"]:checked');
  let delList = [];
  if (checkInputList.length > 0) {
    checkInputList.forEach(item => {
      if (item.id != 'allChk') {
        let obj = {};
        obj.employee_id = item.value;
        delList.push(obj)
      }
    })
  }
  console.log(delList);
  fetch('http://192.168.0.51:8081/myserver/empListDelete', {
      method: 'post',
      headers: {
        'content-type': 'application/json'
      },
      body: JSON.stringify(delList)
    })
    .then(response => response.json())
    .then(data => {
      alert('요청건수:' + data.total +
        '\n삭제한 사번: ' + data.data.toString() +
        '\n총 삭제건수: ' + data.success);
      getEmpList();
    })
    .catch(err => console.log(err))
}

//selected => input 출력
function printSelectJob(e) {
  let selectTag = event.currentTarget;
  let selectedVal = selectTag.options[selectTag.selectedIndex].value;
  selectTag.nextElementSibling.value = selectedVal;
}

//전체 선택
function isAllChecked(e) {
  let checkInputList = document.querySelectorAll('td>input[type="checkbox"]');
  if (event.currentTarget.checked) {
    checkInputList.forEach(item => {
      item.checked = true;
    })
  } else {
    checkInputList.forEach(item => {
      item.checked = false;
    })
  }
}