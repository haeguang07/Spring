package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.yedam.app.dept.service.DeptInfoVO;
import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.mapper.EmpMapper;


public class DeptController {
	@Autowired
	DeptMapper mapper;
	@Autowired
	EmpMapper empmapper;

	//@GetMapping("deptList")
	public String deptList(Model model) {
		model.addAttribute("list", mapper.selectDept());
		return "dept/deptList";
	}

	//@GetMapping("deptUpdate")
	public String deptUpdate(Model model, int deptId) {
		model.addAttribute("empList", empmapper.selectEmp());
		model.addAttribute("loList", mapper.selectLocation());
		model.addAttribute("dept", mapper.selectDeptOne(deptId));
		return "dept/deptUpdate";
	}

	//@GetMapping("deptinsert")
	public String deptinsert(Model model) {
		model.addAttribute("empList", empmapper.selectEmp());
		model.addAttribute("loList", mapper.selectLocation());
		return "dept/deptinsert";
	}

	//@GetMapping("deptdelete")
	public String deptdelete(Model model,int deptId) {
		mapper.deleteDept(deptId);
		return "redirect:deptList";
	}

	//@PostMapping("deptinsert")
	public String deptinsert(Model model, DeptInfoVO vo) {
		if (mapper.insertDept(vo) > 0) {
			return "redirect:deptList";
		} else {
			return "redirect:deptinsert";
		}
	}

	//@PostMapping("deptUpdate")
	public String deptUpdate(Model model, DeptInfoVO vo) {
		if (mapper.updateDept(vo) > 0) {
			return "redirect:deptList";
		} else {
			return "redirect:deptUpdate";
		}
	}

}
