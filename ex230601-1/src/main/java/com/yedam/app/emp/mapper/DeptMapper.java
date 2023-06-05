package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.dept.service.DeptInfoVO;

public interface DeptMapper {
	public List<DeptInfoVO> selectDept();
	public DeptInfoVO selectDeptOne(int departmentId);
	public int updateDept(DeptInfoVO vo);
	public int insertDept(DeptInfoVO vo);
	public int deleteDept(int departmentId);
	public List<Map<String,String>> selectLocation();
}
