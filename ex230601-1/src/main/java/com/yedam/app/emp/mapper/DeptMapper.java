package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.DeptVO;

public interface DeptMapper {
	public List<DeptVO> selectDept();
	public DeptVO selectDeptOne(int departmentId);
	public int updateDept(DeptVO vo);
	public int insertDept(DeptVO vo);
	public int deleteDept(int departmentId);
	public Map<String,String> selectLocation();
}
