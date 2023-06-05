package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptInfoVO {
//	DEPARTMENT_ID   NOT NULL NUMBER(4)    
//	DEPARTMENT_NAME NOT NULL VARCHAR2(30) 
//	MANAGER_ID               NUMBER(6)    
//	LOCATION_ID              NUMBER(4)   
	
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
	
	
}
