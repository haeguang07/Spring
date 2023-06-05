package com.yedam.app.dept.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.dept.service.DeptInfoVO;

public interface DeptInfoMapper {
	// 전체조회
	public List<DeptInfoVO> selectAllDept();

	// 단건
	public DeptInfoVO selectOne(DeptInfoVO vo);

	// 등록
	public int insertDeptInfo(DeptInfoVO vo);

	// 수정
	public int updateDeptInfo(DeptInfoVO vo);

	// 삭제
	public int deleteDeptInfo(int deptId);
	
	
	public List<Map<String,String>> selectLocation();;
	
	
}
