package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
//	EMPLOYEE_ID    NOT NULL NUMBER(6)    
//	FIRST_NAME              VARCHAR2(20) 
//	LAST_NAME      NOT NULL VARCHAR2(25) 
//	EMAIL          NOT NULL VARCHAR2(25) 
//	PHONE_NUMBER            VARCHAR2(20) 
//	HIRE_DATE      NOT NULL DATE         
//	JOB_ID         NOT NULL VARCHAR2(10) 
//	SALARY                  NUMBER(8,2)  
//	COMMISSION_PCT          NUMBER(2,2)  
//	MANAGER_ID              NUMBER(6)    
//	DEPARTMENT_ID           NUMBER(4)
	private int employeeId;
	private String firstName; 
	private String lastName; 
	private String email; 
	private String phoneNumber; 
	private Date hireDate; 
	private String jobId; 
	private double salary; 
	private double commissionPct; 
	private int managerId; 
	private int departmentId; 
	
}
