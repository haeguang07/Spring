package com.yedam.app.dept.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptInfoMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptInfoVO;
import com.yedam.app.emp.mapper.EmpMapper;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptInfoMapper deptMapper;
	@Autowired
	EmpMapper empMapper;
	
	@Override
	public List<DeptInfoVO> getAllDept() {
		
		return deptMapper.selectAllDept();
	}

	@Override
	public DeptInfoVO getDeptInfo(DeptInfoVO vo) {
		
		return  deptMapper.selectOne(vo);
	}

	@Override
	public int insertDeptInfo(DeptInfoVO vo) {
		int result = deptMapper.insertDeptInfo(vo);
		System.out.println("id: " + vo.getDepartmentId());
		return result;
	}

	@Override
	public Map<String, Object> updateDeptList(List<DeptInfoVO> deptVO) {
		Boolean result = false;
		List<Integer> successList = new ArrayList<>();
		int count= 0;
		
		for(DeptInfoVO deptinfo : deptVO) {
			int res = deptMapper.updateDeptInfo(deptinfo);
			if(res>0) {
				//정상적으로 수정이 되었을 경우
				count++;
				successList.add(deptinfo.getDepartmentId());
			}
		}
		
		if(count >0 ) {
			result =true;
		}
		Map<String, Object> map= new HashMap<>();
		map.put("result", result);
		map.put("success", count);
		map.put("deptList", successList);
		return map;
	}

	@Override
	public int deleteDeptList(List<DeptInfoVO> deptVO) {
		int count = 0;
		for (DeptInfoVO deptInfo : deptVO) {
			count += deptMapper.deleteDeptInfo(deptInfo.getDepartmentId());
		}
		return count;
	}

}
