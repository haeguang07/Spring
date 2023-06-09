package com.yedam.java.book.service;

import java.util.Date;

import lombok.Data;
@Data
public class RentVO {
//	rent_no NUMBER PRIMARY KEY,
//	book_no NUMBER NOT NULL,
//	rent_price NUMBER NOT NULL,
//	rent_date DATE NOT NULL,
//	rent_status CHAR(1) DEFAULT '0' NOT NULL
	private int rentNo;
	private int bookNo;
	private int rentPrice;
	private Date rentDate;
	private String rentStatus;
	
	//대여총계 대여 횟수
	private int rentTotal;
	private int rentCount;
	//조인시 도서이름
	private String bookName;
	
}
