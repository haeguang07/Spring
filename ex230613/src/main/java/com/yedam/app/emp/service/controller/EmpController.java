package com.yedam.app.emp.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
@Controller
public class EmpController {
	
	
	@Autowired
	EmpService empService;
	//전체조회
	@GetMapping("empList")
	public String empList(Model model) {
		model.addAttribute("empList", empService.getAllEmp());
		return "empList";
	}
	
	//단건조회 
	@GetMapping("empInfo")
	public String empInfo(Model model,EmpVO empVO) {
		System.out.println(empVO.getEmployeeId());
		model.addAttribute("empInfo", empService.getEmpInfo(empVO));
		return "empInfo";
	}
	@GetMapping("empInsert")
	public void empInsertForm(Model model) {
		model.addAttribute("empVO", new EmpVO());
		
	}
	@PostMapping("empInsert")
	public String empInsert(EmpVO empVO) {
		empService.addEmpInfo(empVO);
		return"redirect:empList";
	}
	
	
}
