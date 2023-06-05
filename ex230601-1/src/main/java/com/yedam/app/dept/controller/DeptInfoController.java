package com.yedam.app.dept.controller;

import java.util.List;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptInfoVO;

@Controller
public class DeptInfoController {
	@Autowired
	DeptService deptService;
	
	//경로 <-> 기능 (View)
	//@RequestMapping(value="deptList", method = RequestMethod.GET )
	//전체조회
	@GetMapping("deptList")
	public String getDeptAllList(Model model) {
		List<DeptInfoVO> list = deptService.getAllDept();
		model.addAttribute("deptList", list);
		return "dept/list";
	}
	//단건조회 -페이지
	@GetMapping("deptInfo")
	public String deptInfo(Model model,DeptInfoVO vo) {
		model.addAttribute("deptInfo", deptService.getDeptInfo(vo));
		return "dept/info";
	}
	
	
	
	//등록 -페이지
	@GetMapping("deptInsert")
	public String deptInsert(Model model,DeptInfoVO vo) {
		model.addAttribute("deptInfo", deptService.getDeptInfo(vo));
		return "dept/insert";
	}
	
	
	//등록 -기능
	
	
	
	//수정 -페이지
	@GetMapping("deptUpdate")
	public String deptUpdate(Model model,DeptInfoVO vo) {
		
		return "dept/update";
	}
	
	
	//수정 -기능
	
	
	
	//삭제 -기능
	@GetMapping("deptDelete")
	public String deptDelete(Model model,DeptInfoVO vo) {
		
		return "redirect:deptList";
	}
	
	
	
}
