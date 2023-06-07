package com.yedam.app.dept.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.yedam.app.dept.service.DeptInfoVO;
import com.yedam.app.dept.service.DeptListVO;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.emp.mapper.EmpMapper;

@Controller
public class DeptInfoController {
	
	@Autowired
	DeptService deptService;
	@Autowired
	EmpMapper empMapper;
	
	//경로 <-> 기능 (View)
	//@RequestMapping(value="deptList", method = RequestMethod.GET )
	//전체조회
	@GetMapping("deptList")
	public String getDeptAllList(Model model, @RequestParam(required = false) String msg, HttpServletRequest requset) {
		List<DeptInfoVO> list = deptService.getAllDept();
		System.out.println("redirect: "+ msg);
		
		Map<String,?> flashMap = RequestContextUtils.getInputFlashMap(requset);
		if(flashMap != null) {
			System.out.println("departmentId: "+ flashMap.get("departmentId"));
		}
		
		model.addAttribute("deptList", list);
		return "dept/list";
	}
	//단건조회 -페이지(페이지 안에서 수정)
	@GetMapping("deptInfo")
	public String deptInfo(Model model,DeptInfoVO vo) {
		model.addAttribute("deptInfo", deptService.getDeptInfo(vo));
		return "dept/info";
	}
	
	
	
	//등록 -페이지
	@GetMapping("deptInsert")
	public String deptInsert(Model model) {
		model.addAttribute("locations", deptService.selectLocation());
		model.addAttribute("empList", empMapper.selectEmp());
		return "dept/insert";
	}
	
	//등록 -기능
	@PostMapping("deptInsert")
	public String deptInsert(DeptInfoVO vo,RedirectAttributes rtt) {
		deptService.insertDeptInfo(vo);
		rtt.addFlashAttribute("departmentId", vo.getDepartmentId());//브라우저 세션의 일시적으로 저장 (경로에 노출이 안됨)
		rtt.addAttribute("msg","test"); //-> ?msg=test 같은 의미
		//return "redirect:deptList?departmentId="+ vo.getDepartmentId();
		return "redirect:deptList";
	}
	
	
	
	//수정 -기능
	//@RequestBody: JSON 포멧을 사용하는 경우 
	//			-> content-type:'application/json'
	@PostMapping("deptUpdate")
	@ResponseBody
	public Map<String, Object> depteUpdate(@RequestBody List<DeptInfoVO> list,RedirectAttributes rtt ) {
	
		Map<String , Object> map = deptService.updateDeptList(list);
	
		//rtt.addFlashAttribute("updateRes", map);
		//return "redirect:deptInfo?departmentId="+list.get(0).getDepartmentId();
		return map;
	}
	
	
	//삭제 -기능
	@GetMapping("deptDelete")
	public String deptDelete(DeptListVO list) {
		int result=deptService.deleteDeptList(list.getDeptList());
		return "redirect:deptList?msg="+result;
	}
	
	
	
}
