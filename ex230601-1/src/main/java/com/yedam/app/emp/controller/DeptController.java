package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.DeptVO;

@Controller
public class DeptController {
	@Autowired
	DeptMapper mapper;
	@Autowired
	EmpMapper empmapper;

	@GetMapping("deptList")
	public String deptList(Model model) {
		model.addAttribute("list", mapper.selectDept());
		return "dept/deptList";
	}

	@GetMapping("deptUpdate")
	public String deptUpdate(Model model, int deptId) {
		model.addAttribute("empList", empmapper.selectEmp());
		model.addAttribute("loList", mapper.selectLocation());
		model.addAttribute("dept", mapper.selectDeptOne(deptId));
		return "dept/deptUpdate";
	}

	@GetMapping("deptinsert")
	public String deptinsert(Model model) {
		model.addAttribute("empList", empmapper.selectEmp());
		model.addAttribute("loList", mapper.selectLocation());
		return "dept/deptinsert";
	}

	@GetMapping("deptdelete")
	public String deptdelete(Model model,int deptId) {
		model.addAttribute("list", mapper.selectDept());
		return "redirect:deptList";
	}

	@PostMapping("deptinsert")
	public String deptinsert(Model model, DeptVO vo) {
		if (mapper.insertDept(vo) > 0) {
			return "redirect:deptList";
		} else {
			return "redirect:deptinsert";
		}
	}

	@PostMapping("deptUpdate")
	public String deptUpdate(Model model, DeptVO vo) {
		if (mapper.updateDept(vo) > 0) {
			return "redirect:deptList";
		} else {
			return "redirect:deptUpdate";
		}
	}

}
