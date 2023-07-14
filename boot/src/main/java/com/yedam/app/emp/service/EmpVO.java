package com.yedam.app.emp.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
	@JsonIgnore
	private String email; 
	private String phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hireDate; 
	private String jobId; 

	private BigDecimal salary; 
	private double commissionPct; 
	private int managerId; 
	private int departmentId; 
	
}
