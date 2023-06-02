package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	public EmpVO selectEmpOne(int empNo);
	public List<EmpVO> selectEmp();
	public List<EmpVO> selectEmp(EmpVO vo);
	public int insertEmp(@Param("lastName") String lastName,@Param("email") String email,@Param("jobId") String jobId);
	public int insertEmp(EmpVO vo);
	public int selectCount(EmpVO vo);
	public List<Map<String,String>> selectJobs();
	public List<Map<String,String>> selectDept();
	public int deleteEmp(int empNo);
	public int empUpdate(EmpVO vo);
}
