package com.yedam.app.emp.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@RestController
public class EmpRestContorller {
	@Autowired
	EmpService empService;
	
	@GetMapping("employees")
	public List<EmpVO> empList() {
		return empService.getAllEmp();
	}
	
	//단건
	@GetMapping("employees/{employeeId}")
	public EmpVO getEmp(@PathVariable int employeeId, EmpVO vo) {
		vo.setEmployeeId(employeeId);
		return empService.getEmpInfo(vo);
	}
	
	//등록
	@PostMapping("employees")
	public EmpVO empInsert(EmpVO vo) {
		empService.addEmpInfo(vo);
		return vo;
	}
	
	//수정(mapper없음)
	@PutMapping("employees")
	public EmpVO empUpdate(@RequestBody EmpVO vo) {
		System.out.println(vo);
		return vo;
	}
	
	//삭제(mapper없음)
	@DeleteMapping("employees/{id}")
	public int empDelete(@PathVariable(name="id") int empId) {
		System.out.println(empId);
		return empId;
	}
}
