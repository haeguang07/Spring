package com.yedam.app.emp.service;

import java.sql.Date;

import lombok.Data;

@Data
public class EmpVO {
	int employeeId;
	String firstName;
	String lastName;
	String email;
	String jobId;
	String departmentId;
	String orderColumn;
	String phoneNumber;
	Date hireDate;
	int salary;
	double commissionPct ;
	int managerId;
	
	
	String[] getDeptArr() {
		
		return departmentId.split(",");
	}
}
