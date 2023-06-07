package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

/*
 * command 
 * POJO : 상속이 필요없음
 */
@Controller 
//객체 생성해서 컨테이너에 빈 등록하고 
//스프링 디스패처스프릿에서 호출할 수 있도록 커멘드 타입으로 만들어줌 
//@Component 를 상속 받은
public class EmpController {
	@Autowired
	EmpMapper mapper;
	
	@GetMapping("empList")
	public String empList(Model model,@ModelAttribute("emp") EmpVO vo) {
		//vo =new EmpVO();
		System.out.println(vo);
		//model.addAttribute("empVO", vo); 자동 주입
		model.addAttribute("empList", mapper.selectEmp(vo));
		
		return "emp/empList";
	}
	
	@GetMapping("empInsert")
	public String empInsertForm(Model model){
		model.addAttribute("jobs", mapper.selectJobs());
		model.addAttribute("dept", mapper.selectDept());
		model.addAttribute("list", mapper.selectEmp());
		return "emp/empInsert";
	}
	
	
	@PostMapping("empInsert")
	public String empInsert(EmpVO vo) {
		mapper.insertEmp(vo);
		System.out.println(vo.getEmployeeId());
		return "redirect:empList";
	}
	
	@GetMapping("empDelete")
	public String empDelete(@RequestParam int empNo) {
		int result=mapper.deleteEmp(empNo);
		
		return "redirect:empList";
	}
	@GetMapping("empUpdate")
	public String empUpdate(Model model, int empNo) {
		model.addAttribute("jobs", mapper.selectJobs());
		model.addAttribute("dept", mapper.selectDept());
		model.addAttribute("list", mapper.selectEmp());
		model.addAttribute("emp", mapper.selectEmpOne(empNo));
		return "emp/empUpdate";
	}
	
	@PostMapping("empUpdate")
	public String empUpdate(EmpVO vo) {
		mapper.empUpdate(vo);
		return "redirect:empList";
	}
	
	
	
}
