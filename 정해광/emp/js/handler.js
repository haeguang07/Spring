init();

// 최초 셋팅
function init() {
    //사원 조회
    getEmpList();

    //부서 정보 조회
    getDeptList();

    //부서명 변경시 데이터
    $('select').eq(0).on('change', function () {
        let dept = $('select').eq(0).val();
        getEmpList(dept);
    });
    //저장 버튼
    $('#saveBtn').on('click', saveEmp);
    //삭제 버튼
    $('#delBtn').on('click', delEmp);
    //선택삭제 버튼
    $('#chkDelBtn').on('click', delEmpList)

    // 사원정보 전체 선택
    document.getElementById('allCheck')
        .addEventListener('click', allCheckEvent);
    // 사원정보 선택취소
    document.getElementById('resetBtn')
        .addEventListener('click', resetCheck);
    // 초기화
    document.getElementById('initBtn')
        .addEventListener('click', formInit);
}


//사원 조회
function getEmpList(deptId) {
    let tbody = $('tbody').eq(0);
    tbody.empty();
    url = 'http://localhost:8099/empList'
    if (deptId > 0) {
        url += '?departmentId=' + deptId
    }
    $.ajax({
        url: url,
        type: 'get',
        success: function (result) {
            result.forEach(item => {
                let tr = makeRow(item);
                tbody.append(tr);
            })
        },
        error: function (err) {
            console.log(err);
        }
    })
}

const feild = ['employeeId', 'lastName', 'hireDate', 'jobId', 'departmentName'];

function makeRow(obj) {
    let tr = $('<tr />').append($('<td/>').append($('<input/>').attr('type', 'checkbox')));
    for (let f of feild) {
        tr.append($('<td />').text(obj[f]));
    }
    tr.on('click', function () {
        let empId = tr.children().eq(1).text();
        empInfo(empId)
    })
    return tr;
}
//tr클릭시 단건 조회
function empInfo(empId) {
    $.ajax({
        url: 'http://localhost:8099/empInfo?employeeId=' + empId,
        type: 'get',
        success: function (result) {
            let inputList = $('table').eq(1).find('input');
            inputList.each((idx, input) => {
                $(input).val(result[input.name]);
            })
            $('#deptData').val(result.departmentId);

        },
        error: function (err) {
            console.log(err);
        }
    })

}

//부서 정보 조회
function getDeptList() {
    $.ajax({
        url: 'http://localhost:8099/deptList',
        type: 'get',
        success: function (result) {
            result.forEach(item => {
                $('select').append($('<option/>').text(item.departmentName).val(item.departmentId))
            })
        },
        error: function (err) {
            console.log(err);
        }
    })
}

//from를 obj로 만들기
function makeEmpInfo() {
    let obj = {}
    let inputList = $('#empInfo').find('input');
    inputList.each((idx, item) => {
        obj[item.name] = item.value;
    })
    obj.departmentId = $('#deptData').val();
    return obj;
}



//사원번호이 있으면 수정 없으면 저장
//사원 등록
function saveEmp() {
    let empInfo = makeEmpInfo();
    let url = 'http://localhost:8099/empInsert';
    if ($('input[name="employeeId"]').val() != '') {
        url = 'http://localhost:8099/empUpdate';
    }
    $.ajax({
        url: url,
        type: 'post',
        data: JSON.stringify(empInfo),
        contentType: 'application/json',
        success: function (result) {
            $('input[name="employeeId"]').val(result.employeeId);
            $('select').eq(0).val(result.departmentId);
            getEmpList(result.departmentId);
        },
        error: function (err) {
            alert('사원 정보를 정확히 입력해주세요')
            console.log(err);
        }
    })
}

//사원 삭제
function delEmp() {
    let empId = $('input[name="employeeId"]').val()
    if (empId == '') {
        alert('삭제할 사원을 선택하세요');
        return;
    } else {
        $.ajax({
            url: 'http://localhost:8099/empDelete?employeeId=' + empId,
            type: 'get',
            success: function (result) {
                let employeeId = result.employeeId
                alert('성공적으로 사원을 삭제하였습니다.\n삭제한 사원: ' + employeeId);
                formInit();
                deleteRow(employeeId);
            },
            error: function (err) {
                console.log(err);
            }
        })
    }

}

//사원 삭제 리스트
function delEmpList() {
    let list = []
    let td = $('input[type="checkbox"]:checked').parent().next();
    td.each((idx, item) => {
        if (item.tagName == "TD") {
            list.push({
                employeeId: $(item).text()
            })
        }
    })
    $.ajax({
        url: 'http://localhost:8099/empDelete',
        type: 'post',
        data: JSON.stringify(list),
        contentType: 'application/json',
        success: function (result) {
            alert('성공한 개수: ' + result.length +
                '\n전체 갯수: ' + list.length);
            
            for (let id of result) {
                deleteRow(id);
            }
        },
        error: function (err) {
            console.log(err);
        }
    })

}
//행 삭제
function deleteRow(empId){
    $('tr>td:has(input)').next().each((idx, item) => {
        if ($(item).text() == empId) {
            $(item).parent().remove();
        }
    })
}




// 사원정보 전체 선택
function allCheckEvent(e) {
    let allCheckTag = document.getElementById('allCheck');
    let checkTags = document.querySelectorAll('[type="checkbox"]');
    checkTags.forEach(el => {
        el.checked = allCheckTag.checked;
    })
}

// 사원정보 선택취소
function resetCheck(e) {
    let checkTags = document.querySelectorAll('[type="checkbox"]');
    checkTags.forEach(el => {
        el.checked = false;
    })
}

// 초기화
function formInit() {
    let insertList = document.querySelectorAll('#empInfo input, #empInfo select');
    insertList.forEach(el => el.value = '');
}