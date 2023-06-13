package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.EmpVO;

//@Mapper//main에 scan 안달면 개별로 어노테이션 넣음
public interface EmpMapper {

	//전체
	public List<EmpVO> selectAllEmp();
	
	//단건
	public EmpVO selectEmpInfo(EmpVO empVO);
	//등록
	public int insertEmpInfo(EmpVO empVO);
	//수정
	
	//삭제
}
