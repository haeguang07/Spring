package com.yedam.app.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RestController
public class EmpRestController {
	@Autowired
	EmpMapper empMapper;
	
	//전체조회
	@GetMapping("emps")
	public List<EmpVO> getEmpList(){	
		EmpVO vo = new EmpVO();
		return empMapper.selectEmp(vo);
	}
	
	//단건조회
	@GetMapping("emps/{employeeId}")
	public EmpVO getEmpInfo(@PathVariable(name="employeeId") int employeeId){
										 //변수 이름과 같으면 생략 가능
		return empMapper.selectEmpOne(employeeId);
	}
	
	//등록
	@PostMapping("emps")
	public EmpVO insertEmpInfo(@RequestBody EmpVO vo) {
		empMapper.insertEmp(vo);
		return vo;
	}
	
	//수정
	@PutMapping("emps/{employeeId}")
	public EmpVO updateEmpInfo(@PathVariable int employeeId,
							   @RequestBody EmpVO vo) {
		vo.setEmployeeId(employeeId);
		empMapper.empUpdate(vo);
		vo = getEmpInfo(employeeId);
		return vo;
	}
	
	//삭제
	@DeleteMapping("emps/{employeeId}")
	public Map<String,Object> deleteEmpInfo(@PathVariable int employeeId) {
		Map<String,Object> map = new HashMap<>();
		boolean success = false;
		int result=empMapper.deleteEmp(employeeId);
		if(result>0) {
			success = true;
		}
		map.put("result",success);
		map.put("employeeId", employeeId);
		return map;
	}
	
}
