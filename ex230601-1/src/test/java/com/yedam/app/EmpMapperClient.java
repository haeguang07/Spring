package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {
	//인터페이스를 상속 받은 구현 클래스를 주입받음
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void select() {
		EmpVO findEmp = empMapper.selectEmpOne(100);
		assertEquals(findEmp.getFirstName(), "Steven");
	}
	@Ignore
	public void selectAll() {
		EmpVO vo = new EmpVO();
		vo.setDepartmentId("50,90");
		vo.setFirstName("e");
		vo.setOrderColumn("first_name");
		List<EmpVO> list= empMapper.selectEmp(vo);
		int result= empMapper.selectCount(vo);
		
	}
	@Ignore
	public void insertOne() {
		EmpVO vo = new EmpVO();
		vo.setLastName("hong1211");
		vo.setEmail("HONG@00412.com");
		vo.setJobId("IT_PROG");
		assertEquals(empMapper.insertEmp(vo), 1);
	}
	@Ignore
	public void test() {
		List<Map<String,String>> list = empMapper.selectJobs();
		System.out.println(list);
		for(Map<String,String> id :list) {
			System.out.println(id.get("JOB_ID"));
		}
		assertNotNull(list);
	}
	
	
}
