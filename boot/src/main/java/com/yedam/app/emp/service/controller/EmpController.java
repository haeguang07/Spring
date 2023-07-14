package com.yedam.app.emp.service.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
@Controller
@RequestMapping("emp/")
public class EmpController {
	
    private SimpMessagingTemplate template;
    @Autowired
    public EmpController(SimpMessagingTemplate template) {
        this.template = template;
    }
    
	@Autowired
	EmpService empService;
	//전체조회
	@GetMapping("empList")
	public String empList(Model model) {
		model.addAttribute("empList", empService.getAllEmp());
		String text = "[" + new Date() + "]:" + "사원목록 조회";
		this.template.convertAndSend("/topic/alam", text);
		return "emp/empList";
	}
	
	//단건조회 
	@GetMapping({"empInfo/{employeeId}","empInfo"})
	public String empInfo(Model model,EmpVO empVO,@PathVariable(required = false) int employeeId) {
		if(employeeId!=0) {
			empVO.setEmployeeId(employeeId);			
		}
		model.addAttribute("empInfo", empService.getEmpInfo(empVO));
		return "emp/empInfo";
	}
	
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("empVO", new EmpVO());
		return "emp/empInsert";
	}
	@PostMapping("empInsert")
	public String empInsert(EmpVO empVO) {
		empService.addEmpInfo(empVO);
		return"redirect:empList";
	}
	
	@GetMapping("empUpdate")
	public String empUpdateForm(Model model,EmpVO vo) {
		model.addAttribute("empVO", empService.getEmpInfo(vo));
		return "emp/empUpdate";
	}
	
}
