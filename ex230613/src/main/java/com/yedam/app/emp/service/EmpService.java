package com.yedam.app.emp.service;

import java.util.List;

public interface EmpService {
	// 전체
	public List<EmpVO> getAllEmp();

	// 단건
	public EmpVO getEmpInfo(EmpVO empVO);

	// 등록
	public int addEmpInfo(EmpVO empVO);
	// 수정

	// 삭제
}
